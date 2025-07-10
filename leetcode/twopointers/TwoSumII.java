package leetcode.twopointers;

//167. Two Sum II - Input Array Is Sorted
public class TwoSumII {

    int[] twoSum(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int[] result= new int[2];
        while (start < end){
            if (nums[start] + nums[end] == target){
                result[0]=start+1;
                result[1]=end+1;
                start++;
                end--;
            } else if (nums[start] + nums[end] > target){
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
