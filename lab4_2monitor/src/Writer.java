
public class Writer implements Runnable {
	
    private Monitor monitor;

    public Writer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            monitor.startWriting(i);
            System.out.println("Writer est� escrevendo " + i);
            monitor.endWriting(i);
        }
    }
}