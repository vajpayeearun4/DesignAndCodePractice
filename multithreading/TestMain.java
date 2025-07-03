package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMain {

    public static void main(String[] args) {

        Queue<String> nonBlockingQueue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition producerWaitCondition = lock.newCondition();
        Condition consumerWaitCondition = lock.newCondition();
        Producer producer = new Producer(nonBlockingQueue, 2, lock, producerWaitCondition, consumerWaitCondition);
        Consumer consumer = new Consumer(nonBlockingQueue, 2, lock, producerWaitCondition, consumerWaitCondition);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Producer implements Runnable {
    Queue<String> nonBlockingQueue;
    private int maxRecords;
    private Lock lock;
    private Condition producerWaitCondition;
    private Condition consumerWaitCondition;

    public Producer(Queue<String> nonBlockingQueue, int maxRecords, Lock lock, Condition producerWaitCondition, Condition consumerWaitCondition) {
        this.nonBlockingQueue = nonBlockingQueue;
        this.maxRecords = maxRecords;
        this.lock = lock;
        this.producerWaitCondition = producerWaitCondition;
        this.consumerWaitCondition = consumerWaitCondition;
    }

    @Override
    public void run() {
        System.out.println("Producer is running");
        lock.lock();
        try {
            while (true) {
                if (nonBlockingQueue.size() >= maxRecords) {
                    producerWaitCondition.await();
                }
                String value = UUID.randomUUID().toString().substring(0, 3);
                this.nonBlockingQueue.add(value);
                System.out.println("Producing input: " + value);
                consumerWaitCondition.signal();

            }
        } catch (InterruptedException e) {
            System.out.println("Producer wait interrupted");
        } finally {
            lock.unlock();
        }
    }
}

class Consumer implements Runnable {
    Queue<String> nonBlockingQueue;
    private int maxRecords;
    private Lock lock;
    private Condition producerWaitCondition;
    private Condition consumerWaitCondition;

    Consumer(Queue<String> nonBlockingQueue, int maxRecords, Lock lock, Condition producerWaitCondition, Condition consumerWaitCondition) {
        this.nonBlockingQueue = nonBlockingQueue;
        this.maxRecords = maxRecords;
        this.lock = lock;
        this.producerWaitCondition = producerWaitCondition;
        this.consumerWaitCondition = consumerWaitCondition;
    }

    @Override
    public void run() {
        System.out.println("Consumer is running");
        lock.lock();
        try {
            while (true) {
                if (nonBlockingQueue.size() == 0) {
                    consumerWaitCondition.await();
                }

                String input = this.nonBlockingQueue.poll();
                System.out.println("Consuming input: " + input);
                producerWaitCondition.signal();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer wait interrupted");
        } finally {
            lock.unlock();
        }

    }
}
