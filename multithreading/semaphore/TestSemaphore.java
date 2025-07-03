package multithreading.semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Bounded Resource Access
//Problem: You have a resource (e.g., a printer) that can be used by only 3 threads at a time. Use a semaphore to ensure that no more than 3 threads access it concurrently.
//
//Goal: Implement a class PrinterPool with a usePrinter() method that enforces this rule.
//
//Concept tested: Basic semaphore usage for concurrent access.
public class TestSemaphore {
    public static void main(String[] args) {
        CustomSemaphore customSemaphore = new CustomSemaphore(1);
        Thread thread1 = new Thread(new PrinterTool(customSemaphore));
        Thread thread2 = new Thread(new PrinterTool(customSemaphore));
        Thread thread3 = new Thread(new PrinterTool(customSemaphore));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class CustomSemaphore {
    private int maxPermit;
    private Lock lock = new ReentrantLock();
    private Condition permitAvailableCond = lock.newCondition();

    CustomSemaphore(int maxPermit) {
        if (maxPermit < 1) {
            throw new IllegalArgumentException("maxPermit must be greater than 0");
        }
        this.maxPermit = maxPermit;
    }

    void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (maxPermit == 0) {
                permitAvailableCond.await();
            }
            maxPermit--;
            permitAvailableCond.signal();
        } finally {
            lock.unlock();
        }
    }

    void release() {
        lock.lock();
        try {
            maxPermit++;
            permitAvailableCond.signal();
        } finally {
            lock.unlock();
        }
    }
}

class PrinterTool implements Runnable {
    private CustomSemaphore customSemaphore;

    PrinterTool(CustomSemaphore customSemaphore) {
        this.customSemaphore = customSemaphore;
    }

    @Override
    public void run() {
        try {
            customSemaphore.acquire();
            System.out.println(Thread.currentThread() + " started...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread() + " ended...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            customSemaphore.release();
        }
    }
}
