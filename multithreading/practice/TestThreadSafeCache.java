package multithreading.practice;

import java.util.Map;
import java.util.concurrent.*;

public class TestThreadSafeCache {

    public static void main(String[] args) {
        ThreadSafeCache<String, String> cache = new ThreadSafeCache<>(5000);


    }
}

class ThreadSafeCache<K, V> {
    private static class CacheEntry<V> {
        V value;
        long expiryTimeInMills;

        public CacheEntry(V value, long expiryTimeInMills) {
            this.value = value;
            this.expiryTimeInMills = System.currentTimeMillis() + expiryTimeInMills;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTimeInMills;
        }
    }

    private final ConcurrentHashMap<K, CacheEntry<V>> cacheMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    public ThreadSafeCache(long delayInMillis) {
        cleaner.scheduleAtFixedRate(this::cleanUp, delayInMillis, delayInMillis, TimeUnit.MILLISECONDS);
    }

    void put(K key, V value, long durationInMillis) {
        cacheMap.put(key, new CacheEntry<>(value, durationInMillis));
    }

    V get(K key) {
        CacheEntry<V> valueEntry = cacheMap.get(key);
        if (valueEntry.isExpired()) {
            cacheMap.remove(key);
            return null;
        }
        return valueEntry.value;
    }

    boolean containsKey(K key) {
        CacheEntry<V> cacheEntry = cacheMap.get(key);
        return cacheEntry != null && !cacheEntry.isExpired();
    }

    private void cleanUp() {
        for (Map.Entry<K, CacheEntry<V>> entry : cacheMap.entrySet()) {
            if (entry.getValue().isExpired()) {
                cacheMap.remove(entry.getKey());
            }
        }
    }

}
