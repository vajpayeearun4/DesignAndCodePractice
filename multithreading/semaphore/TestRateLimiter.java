package multithreading.semaphore;

import java.util.concurrent.*;

//Implement a RateLimiter that allows up to 5 operations per second, using Semaphore and ScheduledExecutorService.
//Requirements
//No more than 5 threads should proceed in any 1-second window.
//
//If more than 5 threads try to acquire, they should wait until permits are refilled.
//
//Use Semaphore for permit control.
//
//Use ScheduledExecutorService to refill permits every second.
public class TestRateLimiter {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(3);
        Runnable task = () -> {
            try {
                rateLimiter.acquire();
                System.out.println(Thread.currentThread() + "executing...");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
        System.out.println("Main thread exiting...");
    }
}

class RateLimiter {
    Semaphore semaphore;
    private int maxPermits;
    private ScheduledExecutorService scheduler;

    public RateLimiter(int maxPermits) {
        this.semaphore = new Semaphore(maxPermits);
        this.maxPermits = maxPermits;
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refillLimit, 1, 1, TimeUnit.SECONDS);
    }

    void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    void refillLimit() {
        int availablePermits = semaphore.availablePermits();
        int permitToAdd = maxPermits - availablePermits;
        if (permitToAdd > 0) {
            semaphore.release(permitToAdd);
        }
    }

}

