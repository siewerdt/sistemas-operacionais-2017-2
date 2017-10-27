package lab4_1produtorconsumidor;
public class Consumer implements Runnable {
	private final Dropbox dropbox;
	private final boolean even;

	public Consumer(boolean even, Dropbox dropbox) {
		this.even = even;
		this.dropbox = dropbox;
	}

	public void run() {
		while (true) {
			if(dropbox.isEmpty()) {
				try {
					// esperando o produtor produzir
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(dropbox.isEvenNumber() == even) {
				dropbox.take(even);	
			}
			System.out.print("");
		}
	}
}
