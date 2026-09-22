package final_prep.dsa.dp;

//https://leetcode.com/problems/house-robber-ii/submissions/2147760627/
public class HouseRoberryII {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int x1 = robInRange(nums, 0, n - 2);
        int x2 = robInRange(nums, 1, n - 1);
        return Math.max(x1, x2);
    }

    int robInRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.max(prev2, prev1);
    }
}
