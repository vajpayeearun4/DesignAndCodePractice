package final_prep.dsa.array.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElem1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums2Map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nums2Map.put(nums2[i], stack.peek());
            } else {
                nums2Map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);

        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums2Map.get(nums1[i]);
        }
        return result;
    }
}
