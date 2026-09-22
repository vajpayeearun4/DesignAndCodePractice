package final_prep.dsa.array.slidewindow;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
public class LongestLengthOf1 {
    public int longestSubarray(int[] nums) {
        int zeroCount=0;
        int left=0;
        int maxLength =0;
        for(int right=0;right< nums.length;right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
}
