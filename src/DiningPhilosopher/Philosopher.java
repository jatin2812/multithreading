package DiningPhilosopher;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{
    Semaphore leftChopstick;
    Semaphore rightChopstick;
    int id;

    public Philosopher(Semaphore leftChopstick, Semaphore rightChopstick, int id){
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.id =id;
    }
    @Override
   public void run(){
        try {
            leftChopstick.acquire();
            rightChopstick.acquire();

            eat();

            leftChopstick.release();
            rightChopstick.release();


        }catch (Exception e){

        }
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating... ");
        Thread.sleep((int) (Math.random() * 1000));
    }
}
