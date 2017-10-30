import java.util.concurrent.Semaphore;

/**
 * 
 * Neste exercício, o problema é permitir que múltiplos readers leiam ao mesmo
 * tempo e somente um único writer possa acessar o conjunto de dados
 * compartilhados em um determinado momento
 * 
 */

public class Main {

	static Semaphore readSemaphore = new Semaphore(1);
    static Semaphore writeSemaphore = new Semaphore(1);
    static int activeReaders = 0;
	
	public static void main(String[] args) {
		
        Reader reader = new Reader(readSemaphore,writeSemaphore,activeReaders);
        Writer writer = new Writer(writeSemaphore);
        
        Thread t1 = new Thread(reader);
        t1.setName("thread1");
        Thread t2 = new Thread(reader);
        t2.setName("thread2");
        Thread t3 = new Thread(writer);
        t3.setName("thread3");
        Thread t4 = new Thread(reader);
        t4.setName("thread4");
        
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
	
}
