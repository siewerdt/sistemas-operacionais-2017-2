
public class Condition {
    private int waiting;

    public Condition() {
        waiting = 0;
    }

    public synchronized boolean isEmpty() {
        if (waiting != 0)
            return false;
        else
            return true;
    }

    public synchronized void releaseAll() {
        waiting = 0;
        notifyAll();
    }

    public synchronized void releaseOne() {
        waiting -= 1;
        notify();
    }

    public synchronized void doWait() throws InterruptedException {
        waiting++;
        wait(10000);
    }
}
