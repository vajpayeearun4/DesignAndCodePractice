package leetcode.tree;

//explain 129. Sum Root to Leaf Numbers
public class Test4 {
    public static void main(String[] args) {

    }

    int sumDigit(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        currSum = currSum * 10 + root.val;
        if (root.left != null && root.right == null) {
            return currSum;
        }
        return sumDigit(root.left, currSum) + sumDigit(root.right, currSum);
    }
}
