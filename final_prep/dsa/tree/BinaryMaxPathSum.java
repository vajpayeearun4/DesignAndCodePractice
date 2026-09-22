package final_prep.dsa.tree;

/*
Binary Tree Maximum Path Sum
 */
public class BinaryMaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxSumP(root);
        return maxSum;
    }
    int findMaxSumP(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, findMaxSumP(root.left));
        int right = Math.max(0, findMaxSumP(root.right));
        int includedPath = root.val + left + right;
        maxSum = Math.max(maxSum, includedPath);

        return root.val + Math.max(left, right);
    }
}
