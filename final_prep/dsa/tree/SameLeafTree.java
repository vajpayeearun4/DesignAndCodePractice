package final_prep.dsa.tree;

import java.util.ArrayList;
import java.util.List;

/*
872. Leaf-Similar Trees
 */
public class SameLeafTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }
}
