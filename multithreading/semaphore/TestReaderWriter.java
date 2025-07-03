package multithreading.semaphore;

//Problem Recap
//Multiple readers can read simultaneously
//
//Only one writer can write at a time
//
//No readers or other writers should be active when a writer is writing

import java.util.concurrent.Semaphore;

public class TestReaderWriter {

    public static void main(String[] args) {
        ReadWriteLockWithWritePreference readWriteLock = new ReadWriteLockWithWritePreference();
        Runnable reader = () -> {
            while (true) {
                try {
                    readWriteLock.startRead();
                    System.out.println(Thread.currentThread().getName() + " reading ...");
                    Thread.sleep(1000);
                    readWriteLock.endRead();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable writer = () -> {
            while (true) {
                try {
                    readWriteLock.startWrite();
                    System.out.println(Thread.currentThread().getName() + " writing ...");
                    Thread.sleep(2000);
                    readWriteLock.endWrite();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(reader, "Reader- " + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writer, "Writer- " + i).start();
        }
    }
}

class ReadWriteLockWithWritePreference {
    private int readCount = 0;
    private int writeCount = 0;
    private Semaphore sharedResourceAccess = new Semaphore(1);

    void startRead() throws InterruptedException {
        readCount++;
        if (readCount == 1) {
            sharedResourceAccess.acquire();
        }
    }

    void endRead() {
        readCount--;
        if (readCount == 0) {
            sharedResourceAccess.release();
        }
    }

    void startWrite() throws InterruptedException {
        writeCount++;
        sharedResourceAccess.acquire();
    }

    void endWrite() {
        sharedResourceAccess.release();
        writeCount--;
    }
}
