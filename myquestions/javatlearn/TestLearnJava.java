package myquestions.javatlearn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestLearnJava {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 7, 3};
        int k = 3;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(
                new Comparator<Pair>() {

                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.val - o1.val;
                    }
                }
        );
        for (int i = 0; i < k; i++) {
            maxHeap.add(new Pair(i, arr[i]));
        }
        result.add(maxHeap.peek().val);
        for (int i = k; i < arr.length; i++) {
            maxHeap.add(new Pair(i, arr[i]));
            while(maxHeap.peek().index <= i-k){
                maxHeap.poll();
            }
            result.add(maxHeap.peek().val);
        }
        System.out.println(result);

    }
}

class Pair {
    int val;
    int index;

    Pair(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
