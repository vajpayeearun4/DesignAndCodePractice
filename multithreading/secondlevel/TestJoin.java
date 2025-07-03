package multithreading.secondlevel;

// join examples
public class TestJoin {
    static int sum1 = 0;
    static int sum2 = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            sum1 = computeSum(1, 5);
        });
        Thread t2 = new Thread(() -> {
            sum2 = computeSum(6, 10);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total sum is: " + sum1 + sum2);

    }

    static int computeSum(int start, int end) {
        int totalSum = 0;
        while (start <= end) {
            totalSum += start++;
        }
        return totalSum;
    }
}
