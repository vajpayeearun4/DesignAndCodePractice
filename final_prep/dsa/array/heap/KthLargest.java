package final_prep.dsa.array.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/2149655956/?envType=study-plan-v2&envId=leetcode-75
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
