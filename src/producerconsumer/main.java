package producerconsumer;

public class main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new consumer(sharedResource));
        Thread consumerThread = new Thread(new producer(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}
