class Monitor {

	private int activeReaders;
    private boolean isWriting;
    private Condition readCondition, writeCondition;

    public Monitor() {
        activeReaders = 0;
        isWriting = false;
        readCondition = new Condition();
        writeCondition = new Condition();
    }

    public synchronized void startReading(int n) {

        System.out.println("Deseja ler " + n);
        if (isWriting || writeCondition.isEmpty()) {
            try {
                System.out.println("Reader está esperando" + n);
                readCondition.doWait();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
        activeReaders ++;
        readCondition.releaseAll();
    }

    public synchronized void endReading(int n) {
        System.out.println("Leu " + n);
        activeReaders -= 1;
        if (writeCondition.isEmpty())
            writeCondition.releaseOne();
        else if (readCondition.isEmpty())
            readCondition.releaseOne();
        else
            writeCondition.releaseAll();
    }

    public synchronized void startWriting(int n) {
        System.out.println("Deseja escrever " + n);
        if (activeReaders != 0 || isWriting) {
            try {
                System.out.println("Writer está aguardando " + n);
                writeCondition.doWait();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
        isWriting = true;
    }

    public synchronized void endWriting(int n) {
        System.out.println("Escreveu " + n);
        isWriting = false;
        if (readCondition.isEmpty())
            readCondition.releaseOne();
        else if (writeCondition.isEmpty())
            writeCondition.releaseOne();
        else
            readCondition.releaseAll();
    }
}