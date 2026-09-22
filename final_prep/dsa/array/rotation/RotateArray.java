package final_prep.dsa.array.rotation;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    public void rotate2nd(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int count = 0, start = 0;
        while (count < n) {
            int current = start;
            int prev = nums[start];
            do {
                int nextInd = (current + k) % n;
                int temp = nums[nextInd];
                nums[nextInd] = prev;
                prev = temp;
                current = nextInd;
                count++;

            } while (current != start);
            start++;
        }

    }

    void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
