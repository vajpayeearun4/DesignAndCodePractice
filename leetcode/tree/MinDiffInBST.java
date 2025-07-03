package leetcode.tree;

//530. Minimum Absolute Difference in BST
public class MinDiffInBST {

    public static void main(String[] args) {

    }

    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;

    void minDiffCalculate(TreeNode root){
        if (root == null) {
            return;
        }
        minDiffCalculate(root.left);
        if (prev!=null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        minDiffCalculate(root.right);

    }
}
