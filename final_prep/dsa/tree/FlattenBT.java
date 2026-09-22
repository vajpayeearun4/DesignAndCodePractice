package final_prep.dsa.tree;

public class FlattenBT {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rightSub = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = rightSub;
        flatten(rightSub);
    }
}
