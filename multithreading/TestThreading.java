package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreading {

    public static void main(String[] args) {
        OddEvenZeroPrinter oddEvenZeroPrinter = new OddEvenZeroPrinter(5);

        Thread zeroThreadThread = new Thread(() -> {
            oddEvenZeroPrinter.printZero();
        });
        Thread oddThreadThread = new Thread(() -> {
            oddEvenZeroPrinter.printOdd();
        });
        Thread evenThreadThread = new Thread(() -> {
            oddEvenZeroPrinter.printEven();
        });
        zeroThreadThread.start();
        oddThreadThread.start();
        evenThreadThread.start();
    }
}

class OddEvenZeroPrinter {
    int maxValue;
    volatile int currentValue = 1;
    volatile boolean isZeroChance = true;
    Lock lock = new ReentrantLock();
    Condition zeroCondition = lock.newCondition();
    Condition oddCondition = lock.newCondition();
    Condition evenCondition = lock.newCondition();

    OddEvenZeroPrinter(int maxValue) {
        this.maxValue = maxValue;
    }

    void printOdd() {
        try {
            lock.lock();
            while (currentValue <= maxValue) {
                while (isZeroChance || currentValue % 2 == 0) {
                    oddCondition.await();
                }
                System.out.print(currentValue + " ");
                currentValue++;
                isZeroChance = true;
                zeroCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void printEven() {
        try {
            lock.lock();
            while (currentValue <= maxValue) {
                while (isZeroChance || currentValue % 2 != 0) {
                    evenCondition.await();
                }
                System.out.print(currentValue + " ");
                currentValue++;
                isZeroChance = true;
                zeroCondition.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void printZero() {
        try {
            lock.lock();
            while (currentValue < maxValue) {
                if (!isZeroChance) {
                    zeroCondition.await();
                }
                System.out.print(0 + " ");
                isZeroChance = false;
                oddCondition.signal();
                evenCondition.signal();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
