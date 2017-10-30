import java.util.concurrent.Semaphore;

public class Writer implements Runnable {
	
	private Semaphore writeSemaphore;
	
	public Writer(Semaphore writeSemaphore) {
		this.writeSemaphore = writeSemaphore;		
	}
	
    @Override
    public void run() {
        try {
            writeSemaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getName() + " está escrevendo");
            Thread.sleep(1000);
            System.out.println("Thread " + Thread.currentThread().getName() + " escreveu");
            writeSemaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

