package lab4_3semaforo;

public class Philosopher extends Thread {

	private Fork forkRight;
	private Fork forkLeft;

	Philosopher(Fork forkRight, Fork forkLeft) {
		this.forkRight = forkRight;
		this.forkLeft = forkLeft;
	}

	public void run() {

		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			eat();
		}
	}

	private void eat() {
		if (forkRight.acquire()) {
			if (forkLeft.acquire()) {
				try {
					sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				forkLeft.release();
				forkRight.release();
			} else {
				forkRight.release();
			}
		}
	}
}