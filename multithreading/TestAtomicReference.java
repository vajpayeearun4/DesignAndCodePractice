package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager();
        Runnable reader = () -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Refresh interval " + configManager.getConfig().refreshInterval);
        };
        Runnable writer = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Updating interval " + 10);
            configManager.updateConfig(10);
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Thread(reader));
        }
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Thread(writer));
        }
        executorService.shutdown();
    }
}

class Config {
    int refreshInterval;

    public Config(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }
}

class ConfigManager {
    private final AtomicReference<Config> configRef = new AtomicReference<>(new Config(2));

    Config getConfig() {
        return configRef.get();
    }

    void updateConfig(int newInterval) {
        Config newConfig = new Config(newInterval);
        configRef.set(newConfig);
    }
}
