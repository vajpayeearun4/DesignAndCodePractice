package final_prep.dsa.tree.views;

import final_prep.dsa.tree.TreeNode;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class LeftView {
    public ArrayList<Integer> leftView(TreeNode root) {
        // code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        buildLeftView(root, result, 0);
        return result;
    }

    void buildLeftView(TreeNode root, ArrayList<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        buildLeftView(root.left, result, depth + 1);
        buildLeftView(root.right, result, depth + 1);
    }
}
