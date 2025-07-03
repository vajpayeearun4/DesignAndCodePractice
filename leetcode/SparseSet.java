package leetcode;

public class SparseSet {
    int[] dense;
    int[] sparse;
    int size;
    final int capacity;

    public SparseSet(int capacity, int[] sparse, int[] dense) {
        this.capacity = capacity;
        this.sparse = sparse;
        this.dense = dense;
    }

    public void insert(int x) {
        if (x < 0 && x >= capacity) throw new IllegalArgumentException("Out of bounds");
        dense[size] = x;
        sparse[x] = size;
        size++;
    }

    public void remove(int x) {
        if (x < 0 && x >= capacity) throw new IllegalArgumentException("Out of bounds");
        int index = sparse[x];
        int last = dense[size - 1];
        dense[index] = last;
        sparse[x] = index;
        size--;
    }

    void clear() {
        size = 0;
    }

    int size() {
        return size;
    }

    boolean contains(int x) {
        if (x < 0 && x >= capacity) throw new IllegalArgumentException("Out of bounds");
        return sparse[x] < size && dense[sparse[x]] == x;
    }
}
