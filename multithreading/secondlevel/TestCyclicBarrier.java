package multithreading.secondlevel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, ()->{
        });
        Player player1 = new Player(barrier, 1, "Player 1");
        Player player2 = new Player(barrier, 2, "Player 2");
        Player player3 = new Player(barrier, 3, "Player 3");
        player1.start();
        player2.start();
        player3.start();
    }
}

class Player extends Thread {
    CyclicBarrier barrier;
    int delay;
    String name;
    Player(CyclicBarrier barrier, int delay, String name) {
        super(name);
        this.barrier = barrier;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " waiting...");
        try {
            barrier.await();
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " started...");
    }
}
