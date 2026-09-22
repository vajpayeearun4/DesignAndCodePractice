package final_prep.dsa.array.stack;

import java.util.Stack;

public class SimplifiedPath {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] pathArr = path.split("/");
        int n = pathArr.length;
        for (int i = 0; i < n; i++) {
            if (pathArr[i].isEmpty() || pathArr[i].equals(".")) {
                continue;
            }
            if (pathArr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(pathArr[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
