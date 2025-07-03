package myquestions.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    public static void main(String[] args) {
        Runnable task1 = () -> System.out.println("Executing Task1");
        Runnable task2 = () -> System.out.println("Executing Task2");
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(task1);
        executorService.submit(task2);
    }
}

