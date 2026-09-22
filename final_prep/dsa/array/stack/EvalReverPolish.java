package final_prep.dsa.array.stack;

import java.util.Stack;

public class EvalReverPolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {

                int b = stack.pop();
                int a = stack.pop();
                int result;
                switch (str) {
                    case "+": {
                        result = a + b;
                        break;
                    }
                    case "-": {
                        result = a - b;
                        break;
                    }
                    case "*": {
                        result = a * b;
                        break;
                    }
                    case "/": {
                        result = a / b;
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Invalid Argument");


                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }

        }
        return stack.pop();
    }
}
