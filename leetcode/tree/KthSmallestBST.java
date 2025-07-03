package leetcode.tree;

public class KthSmallestBST {
    public static void main(String[] args) {

    }

    int count = 0;
    int result = 0;

    void kthSmallestInBST(TreeNode root, int k){
        if (root == null) {
            return;
        }
        kthSmallestInBST(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        kthSmallestInBST(root.right, k);
    }
}
