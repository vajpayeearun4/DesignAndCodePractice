package final_prep.dsa.array.stack;

import java.util.Stack;

public class AsteriodCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {

                if (stack.peek() < -asteroids[i]) {
                    stack.pop();
                } else if (stack.peek() == -asteroids[i]) {
                    isDestroyed = true;
                    stack.pop();
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed) {
                stack.push(asteroids[i]);
            }

        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
