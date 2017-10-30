import java.util.concurrent.Semaphore;

public class Reader implements Runnable {
	
	private Semaphore readSemaphore;
	private Semaphore writeSemaphore;
	private int readCount;
	
	public Reader(Semaphore readSemaphore, Semaphore writeSemaphore, int activeReaders) {
		this.readSemaphore = readSemaphore;	
		this.writeSemaphore = writeSemaphore;	
		this.readCount = activeReaders;	
	}
	
    @Override
    public void run() {
        try {
            readSemaphore.acquire();
            readCount++;
            if (readCount == 1) {
                writeSemaphore.acquire();
            }
            readSemaphore.release();

            System.out.println("Thread "+Thread.currentThread().getName() + " está lendo");
            Thread.sleep(1500);
            System.out.println("Thread "+Thread.currentThread().getName() + " leu");

            readSemaphore.acquire();
            readCount--;
            if(readCount == 0)
                writeSemaphore.release();
            readSemaphore.release();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
