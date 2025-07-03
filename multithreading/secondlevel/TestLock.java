package multithreading.secondlevel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {
    public static void main(String[] args) {

    }
}

class HighPerformanceCache<K, V>{
    Map<K, V> keyValueMap = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public V get(K key){
        try{
            readLock.lock();
            return keyValueMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V value){
        try {
            writeLock.lock();
            keyValueMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}
