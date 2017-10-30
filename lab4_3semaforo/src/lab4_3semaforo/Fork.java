package lab4_3semaforo;

import java.util.concurrent.Semaphore;

public class Fork {

	public static Semaphore fork = new Semaphore(1);
	public int id;

	public Fork(int id) {
	    this.id = id;
	}

	public int getId() {
	    return id;
	}

	public boolean acquire() {
	    return fork.tryAcquire();
	}

	public void release() {
	    fork.release();
	}	
}