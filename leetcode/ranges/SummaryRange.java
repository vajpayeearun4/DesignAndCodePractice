package leetcode.ranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    public static void main(String[] args) {

    }

    List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int start = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start == i) {
                result.add(nums[i] + "");
            } else {
                result.add(nums[start] + "->" + nums[i]);
            }
            i++;
        }
        return result;
    }
}
