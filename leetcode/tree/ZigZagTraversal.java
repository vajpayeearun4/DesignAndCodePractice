package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode 103: Binary Tree Zigzag Level Order Traversal
public class ZigZagTraversal {

    public static void main(String[] args) {

    }

    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (leftToRight) {
                    levelList.addLast(currNode.val);
                } else {
                    levelList.addFirst(currNode.val);
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }


            }
            leftToRight=!leftToRight;
            result.add(levelList);
        }
        return result;
    }
}
