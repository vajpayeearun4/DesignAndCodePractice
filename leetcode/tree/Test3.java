package leetcode.tree;

//112. Path Sum
public class Test3 {
    public static void main(String[] args) {

    }

    boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) && hasPathSum(root.right, targetSum - root.val);
    }
}
