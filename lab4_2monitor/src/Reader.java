
public class Reader implements Runnable {
    
	private Monitor monitor;

    public Reader(Monitor monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            monitor.startReading(i);
            System.out.println("Reader está lendo " + i);
            monitor.endReading(i);
        }

    }
}
