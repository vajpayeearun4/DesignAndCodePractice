package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestOddEven {
    static volatile int currVal=1;
    public static void main(String[] args) {
        int n = 25;
        Lock lock = new ReentrantLock();
        Condition evenCondition = lock.newCondition();
        Condition oddCondition = lock.newCondition();
        OddThread oddThread = new OddThread(n, lock, evenCondition, oddCondition);
        EvenThread evenThread = new EvenThread(n, lock, evenCondition, oddCondition);
        oddThread.start();
       evenThread.start();
    }
}

class OddThread extends Thread {
    private int maxValue;
    private Lock lock;
    private Condition evenCondition;
    private Condition oddCondition;

    OddThread(int n, Lock lock, Condition evenCondition, Condition oddCondition) {
        this.maxValue = n;
        this.lock = lock;
        this.evenCondition = evenCondition;
        this.oddCondition = oddCondition;
    }

    @Override
    public void run() {
        System.out.println("Odd thread started");
        try {
            lock.lock();
            while (TestOddEven.currVal < maxValue) {
                while (TestOddEven.currVal % 2 == 0) {
                    oddCondition.await();
                }
                System.out.print(TestOddEven.currVal + " ");
                TestOddEven.currVal += 1;
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

class EvenThread extends Thread {
    private int maxValue;
    private Lock lock;
    private Condition evenCondition;
    private Condition oddCondition;

    EvenThread(int n, Lock lock, Condition evenCondition, Condition oddCondition) {
        this.maxValue = n;
        this.lock = lock;
        this.evenCondition = evenCondition;
        this.oddCondition = oddCondition;
    }

    @Override
    public void run() {
        System.out.println("Even thread started");
        try {
            lock.lock();
            while (TestOddEven.currVal < maxValue) {
                while (TestOddEven.currVal % 2 != 0) {
                    evenCondition.await();
                }
                System.out.print(TestOddEven.currVal + " ");
                TestOddEven.currVal += 1;
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}


