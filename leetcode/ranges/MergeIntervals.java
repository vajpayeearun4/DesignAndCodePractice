package leetcode.ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

    }

    int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> results = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (currentInterval[1] >= next[0]) {
                currentInterval[1] = Math.max(currentInterval[1], next[1]);
            } else {
                results.add(currentInterval);
                currentInterval = next;
            }
        }
        results.add(currentInterval);
        return results.toArray(new int[results.size()][]);
    }
}
