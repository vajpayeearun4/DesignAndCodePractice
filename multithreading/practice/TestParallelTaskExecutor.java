package multithreading.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestParallelTaskExecutor {
    public static void main(String[] args) {

    }
}

class ParallelTaskExecutor {

    static class Task {
        String name;
        List<String> dependencies;
        Runnable action;

        public Task(String name, List<String> dependencies, Runnable action) {
            this.name = name;
            this.dependencies = dependencies == null ? List.of() : dependencies;
            this.action = action;
        }
    }

    private final ConcurrentHashMap<String, Task> taskMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<String>> dependentsTaskMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AtomicInteger> dependenciesCountMap = new ConcurrentHashMap<>();
    private final ExecutorService executorService;
    private final BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
    private final CountDownLatch countDownLatch;

    public ParallelTaskExecutor(List<Task> tasks, int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.countDownLatch = new CountDownLatch(tasks.size());
        for (Task task : tasks) {
            taskMap.put(task.name, task);
            dependenciesCountMap.put(task.name, new AtomicInteger(task.dependencies.size()));
            for (String dependency : task.dependencies) {
                dependentsTaskMap.computeIfAbsent(dependency, k -> new ArrayList<>()).add(task.name);
            }
        }

        for (Task task : tasks) {
            if (task.dependencies.isEmpty()) {
                blockingDeque.offer(task.name);
            }
        }
    }

    void execute() {
        while (countDownLatch.getCount() > 0) {
            try {
                String taskName = blockingDeque.take();
                executorService.submit(() -> runTaskName(taskName));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void runTaskName(String taskName) {
        try {
            Task task = taskMap.get(taskName);
            System.out.println("Running ..." + taskName);
            task.action.run();
        } finally {
            countDownLatch.countDown();
        }
    }

    void shutdown() {
        executorService.shutdown();
    }
}