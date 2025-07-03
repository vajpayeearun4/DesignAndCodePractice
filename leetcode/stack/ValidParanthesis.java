package leetcode.stack;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {

    }

    boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char poppedCh = stack.pop();
                if ((ch == ')' && poppedCh != '(') || (ch == '}' && poppedCh != '{') || (ch == ']' && poppedCh != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
