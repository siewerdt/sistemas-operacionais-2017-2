package lab4_1produtorconsumidor;
import java.util.Random;

public class Producer implements Runnable{
	private Dropbox dropbox;

	public Producer(Dropbox dropbox) {
		this.dropbox = dropbox;
	}

	public void run() {
		Random random = new Random();
		while (true) {
			int number = random.nextInt(10);
			try {
				Thread.sleep(random.nextInt(100));
				if(dropbox.isEmpty())
					dropbox.put(number);
			} catch (InterruptedException e) {
			}
		}
	}
}
