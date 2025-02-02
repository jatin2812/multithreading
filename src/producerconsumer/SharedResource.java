package producerconsumer;

import java.util.LinkedList;

public class SharedResource {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    public synchronized void produce(int value) throws InterruptedException{
        if(buffer.size()==capacity) {
            wait();
        }
        buffer.add(value);
        System.out.println("produced value: " +value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();  // Wait if buffer is empty
        }
        int t =  buffer.removeLast();
        System.out.println("consumed last : " + t);
        notify();
    }
}
