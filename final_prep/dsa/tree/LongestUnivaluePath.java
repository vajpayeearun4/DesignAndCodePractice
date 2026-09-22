package final_prep.dsa.tree;

/*
687. Longest Univalue Path
 */
public class LongestUnivaluePath {
    int answer = 0;
    public int longestUnivaluePath(TreeNode root) {
        findLengthOfPath(root);
        return answer;
    }

    int findLengthOfPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findLengthOfPath(root.left);
        int right = findLengthOfPath(root.right);
        int leftPath = 0, rightPath = 0;
        if(root.left!=null && root.left.val == root.val){
            leftPath = left+1;
        }
        if(root.right!=null && root.right.val == root.val){
            rightPath = right+1;
        }

        answer = Math.max(answer , leftPath + rightPath);

        return Math.max(leftPath, rightPath);

    }
}
