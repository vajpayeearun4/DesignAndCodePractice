package final_prep.dsa.tree;

/*
222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    int getLeftHeight(TreeNode root) {
        int left = 0;
        while (root != null) {
            left++;
            root = root.left;
        }
        return left;
    }

    int getRightHeight(TreeNode root) {
        int right = 0;
        while (root != null) {
            right++;
            root = root.right;
        }
        return right;
    }
}
