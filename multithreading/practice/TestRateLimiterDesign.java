package multithreading.practice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestRateLimiterDesign {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(2);
        Runnable t1 = ()->{
            rateLimiter.acquire();
            System.out.println("Executing thread..." + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            new Thread(t1).start();
        }
    }
}

class RateLimiter{
    private int maxPermits;
    private Semaphore semaphore;
    private ScheduledExecutorService scheduledExecutorService;
    public RateLimiter(int maxPermits) {
        this.maxPermits = maxPermits;
        this.semaphore = new Semaphore(maxPermits);
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.scheduledExecutorService.scheduleAtFixedRate(this:: refill, 1, 1, TimeUnit.SECONDS);
    }

    void acquire(){
        try {
            this.semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void refill(){
        int availablePermits = this.semaphore.availablePermits();
        int permitToAdd = this.maxPermits-availablePermits;
        if (permitToAdd > 0) {
            semaphore.release(permitToAdd);
        }
    }
}
