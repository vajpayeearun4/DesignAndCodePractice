package multithreading.secondlevel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestOddEventNew {
    static int maxValue = 20;
    static volatile int currValue = 1;

    public static void main(String[] args) {
        System.out.println("Testing Odd Even..");
        Lock lock = new ReentrantLock();
        Condition oddCondition = lock.newCondition();
        Condition evenCondition = lock.newCondition();
        OddPrintingThread oddPrintingThread = new OddPrintingThread(lock, evenCondition, oddCondition);
        EvenPrintingThread evenPrintingThread = new EvenPrintingThread(lock, evenCondition, oddCondition);
        oddPrintingThread.start();
        evenPrintingThread.start();
        System.out.println("Ended..");
    }
}

class OddPrintingThread extends Thread {
    Lock lock;
    Condition evenCondition;
    Condition oddCondition;

    public OddPrintingThread(Lock lock, Condition evenCondition, Condition oddCondition) {
        this.lock = lock;
        this.evenCondition = evenCondition;
        this.oddCondition = oddCondition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (TestOddEventNew.currValue < TestOddEventNew.maxValue) {
                if (TestOddEventNew.currValue % 2 == 0) {
                    oddCondition.await();
                }
                System.out.print(TestOddEventNew.currValue + " ");
                TestOddEventNew.currValue++;
                evenCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

class EvenPrintingThread extends Thread {
    Lock lock;
    Condition evenCondition;
    Condition oddCondition;

    public EvenPrintingThread(Lock lock, Condition evenCondition, Condition oddCondition) {
        this.lock = lock;
        this.evenCondition = evenCondition;
        this.oddCondition = oddCondition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (TestOddEventNew.currValue < TestOddEventNew.maxValue) {
                if (TestOddEventNew.currValue % 2 != 0) {
                    evenCondition.await();
                }
                System.out.print(TestOddEventNew.currValue + " ");
                TestOddEventNew.currValue++;
                oddCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
