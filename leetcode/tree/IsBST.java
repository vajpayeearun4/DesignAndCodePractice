package leetcode.tree;

public class IsBST {

    public static void main(String[] args) {

    }

    boolean isBST(TreeNode root, int min , int max){
        if (root == null) {
            return true;
        }
        return root.val <=max && root.val >=min && isBST(root.left, min, root.val-1) && isBST(root.right, root.val+1, max);
    }
}
