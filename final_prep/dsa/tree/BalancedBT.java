package final_prep.dsa.tree;


public class BalancedBT {

    public static void main(String[] args) {

    }

    boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = height(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(rh, lh);
    }
}
