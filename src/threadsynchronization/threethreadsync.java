package threadsynchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class threethreadsync implements Runnable{
    private static int number = 1; // Start from 1
    private static int turn = 1;
    private int threadid;
    private static final Object LOCK = new Object();

    public  void run() {
        synchronized (LOCK) {
            while (number <= 100) {
                while (turn != threadid) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if(number<=100)
                System.out.println(number);

                number++;
                turn = (turn % 3) + 1;

                LOCK.notifyAll();
            }
        }
    }

    public threethreadsync(int id){
        this.threadid=id;
    }
}
