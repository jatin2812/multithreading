package DiningPhilosopher;

import java.util.concurrent.Semaphore;

public class main {
    public static void main(String[] args) {
        Semaphore[] chopsticks  = new Semaphore[5];

        for(int i=0;i<5;i++){
            chopsticks[i]= new Semaphore(1);
        }

        Thread[] philosophers = new Thread[5];

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Thread(new Philosopher(
                    chopsticks[i], chopsticks[(i + 1) % 5], i
            ));
            philosophers[i].start();
        }


    }
}
