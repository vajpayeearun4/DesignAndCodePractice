package final_prep.dsa.array.stack;

import java.util.Arrays;
import java.util.Stack;

public class NGEIICircular {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[index];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }
}
