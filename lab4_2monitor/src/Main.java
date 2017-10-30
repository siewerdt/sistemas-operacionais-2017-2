public class Main {

	public static void main(String[] args) {
		
		Monitor monitor = new Monitor();
		
		Reader reader = new Reader(monitor);
		Writer writer = new Writer(monitor);
		
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
