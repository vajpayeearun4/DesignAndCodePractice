package final_prep.dsa.tree;

public class MinAbsDiff {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prevNode.val));
        }
        prevNode = root;
        inorder(root.right);
    }
}
