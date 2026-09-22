package final_prep.dsa.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class TestMaxSumSubArrayK {

    public static void main(String[] args) {

    }

    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public long maxSubarraySumWithDistinct(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        long maxSum = 0;
        if (freqMap.size() == k) {
            maxSum = windowSum;
        }

        for (int i = k; i < arr.length; i++) {
            windowSum+=arr[i];
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
            int leftElem = arr[i-k];
            windowSum-=leftElem;
            freqMap.put(leftElem, freqMap.get(leftElem)-1);
            if (freqMap.size() == k){
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }


}
