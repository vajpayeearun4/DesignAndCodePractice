package final_prep.dsa.array.stack;

import java.util.Stack;

/*
739. Daily Temperatures
 */
public class TestDailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }
        return result;
    }
}
