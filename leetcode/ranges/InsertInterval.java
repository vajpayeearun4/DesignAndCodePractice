package leetcode.ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

    }

    int[][] insertInterval(int[][] intervals, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int i =0;
        int n = intervals.length;
        while(i < n && intervals[i][1]< newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <=newInterval[1]){
            newInterval[0]= Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
