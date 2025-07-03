package leetcode.tree;

import org.w3c.dom.Node;

public class Test1 {
    public static void main(String[] args) {

    }

    //Leetcode 116: Populating Next Right Pointers in Each Node (I)
    TreeNode connect(TreeNode root) {
        if (root == null) return null;
        TreeNode leftMost = root.left;
        while (leftMost != null) {
            TreeNode firstNode = root;
            while (firstNode != null) {
                firstNode.left.next = firstNode.right;
                if (firstNode.next != null) {
                    firstNode.right.next = firstNode.next.left;
                }
                firstNode = firstNode.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // Leetcode 117. Populating Next Right Pointers in Each Node II
    TreeNode connectNotPerfectTree(TreeNode root) {
        if (root == null) return null;

        TreeNode curr = root;
        while (curr != null) {
            TreeNode dummy = new TreeNode();
            TreeNode prev = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}


