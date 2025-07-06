package leetcode.tree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    BSTIterator(TreeNode root){
        pushLeft(root);
    }
    void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    int next(){
        TreeNode node = stack.pop();
        if(node.right!=null){
            pushLeft(node.right);
        }
        return node.val;
    }

    boolean hasNext(){
        return !stack.isEmpty();
    }



}
