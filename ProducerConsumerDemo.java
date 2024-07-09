package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
        	System.out.println("Producer is waiting as buffer is full");
            wait();
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
        	System.out.println("Consumer is waiting as buffer is empty");
            wait();
        }
        int value = queue.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer, String name) {
        super(name);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                buffer.produce(value++);
                Thread.sleep(1000); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer, String name) {
        super(name);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(1500); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Buffer capacity is 5

        Producer producer1 = new Producer(buffer, "Producer-1");
        Producer producer2 = new Producer(buffer, "Producer-2");
        Consumer consumer1 = new Consumer(buffer, "Consumer-1");
        Consumer consumer2 = new Consumer(buffer, "Consumer-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
