package multithreading.secondlevel;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName() + "-Executing");
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count is : "+ counter.get());
    }
}
