package multithreading.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println(Thread.currentThread().getName() + " locked Lock1");
                Thread.sleep(100);
                try {
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName() + " locked Lock2");
                } finally {
                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println(Thread.currentThread().getName() + " locked Lock2");
                Thread.sleep(100);
                try {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName() + " locked Lock1");
                } finally {
                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
            }
        }, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread ended");
    }
}
