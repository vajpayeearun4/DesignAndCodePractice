package final_prep.dsa.tree;

/*
112. Path Sum
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        int remaining = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return remaining == 0;
        }
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
