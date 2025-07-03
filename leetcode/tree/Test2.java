package leetcode.tree;

//Leetcode 114: Flatten Binary Tree to Linked List
public class Test2 {
    private TreeNode prev;
    public static void main(String[] args) {

    }

    void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
