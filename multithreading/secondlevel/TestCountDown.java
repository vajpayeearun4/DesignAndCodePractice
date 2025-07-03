package multithreading.secondlevel;

import java.util.concurrent.CountDownLatch;

public class TestCountDown {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ServiceHandler service1 =  new ServiceHandler(latch,"service 1" , 1);
        ServiceHandler service2 =  new ServiceHandler(latch,"service 2" , 3);
        ServiceHandler service3 =  new ServiceHandler(latch,"service 3" , 4);
        service1.start();
        service2.start();
        service3.start();
        latch.await();
        System.out.println("All services starte");
    }


}

class ServiceHandler extends Thread {
    CountDownLatch latch;
    String name;
    int delay;

    public ServiceHandler(CountDownLatch latch, String name, int delay) {
        this.latch = latch;
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay * 1000);
            System.out.println("Service " + name + " started");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }

    }
}
