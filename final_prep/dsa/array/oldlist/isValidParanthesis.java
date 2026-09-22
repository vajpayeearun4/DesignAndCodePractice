package final_prep.dsa.array.oldlist;

import java.util.Stack;

public class isValidParanthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popped = stack.pop();
                if ((ch == ']' && popped != '[') || (ch == '}' && popped != '{') || (ch == ')' && popped != '(')) {
                    return false;
                }

            }

        }
        return stack.isEmpty();

    }
}
