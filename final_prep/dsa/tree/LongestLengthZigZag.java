package final_prep.dsa.tree;

/*
1372. Longest ZigZag Path in a Binary Tree
 */
public class LongestLengthZigZag {

    int maxLength = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        zigzagRec(root, 0, 0);
        return maxLength;
    }

    void zigzagRec(TreeNode root, int leftLength, int rightLength) {
        if (root == null) {
            return;
        }
        maxLength = Math.max(maxLength, Math.max(leftLength, rightLength));
        zigzagRec(root.left, rightLength + 1, 0);
        zigzagRec(root.right, 0, leftLength + 1);

    }
}
