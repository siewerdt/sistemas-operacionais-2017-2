package lab4_3semaforo;

public class Main {

	public static void main(String[] args) {
		Fork[] forks = new Fork[5];
		Philosopher[] philosophers = new Philosopher[5];

		for (int i=0; i<forks.length; i++)
			forks[i] = new Fork(i);

		for (int i=0; i<philosophers.length; i++) {
			if (i != (philosophers.length - 1)) {
				philosophers[i] = new Philosopher(forks[i], forks[i + 1]);
				philosophers[i].start();
			} else {
				philosophers[i] = new Philosopher(forks[0], forks[i]);
				philosophers[i].start();
			}
		}
	}
}