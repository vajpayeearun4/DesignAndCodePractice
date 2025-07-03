package leetcode.tree;
//Leetcode 236: Lowest Common Ancestor of a Binary Tree
public class Test6 {

    public static void main(String[] args) {

    }

    TreeNode lca(TreeNode root, int key1, int key2){
        if(root == null || root.val == key1 || root.val == key2){
            return root;
        }
        TreeNode leftNode =lca(root.left, key1, key2);
        TreeNode rightNode = lca(root.right, key1, key2);
        if(leftNode!=null && rightNode!=null){
            return root;
        }
        return leftNode!=null ? leftNode: rightNode;
    }
}
