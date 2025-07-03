package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

// 662. Maximum Width of Binary Tree

public class Test5 {

    public static void main(String[] args) {

    }

    int findMaxWidth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> currPair = queue.poll();
                TreeNode currNode = currPair.node;
                int currIndex = currPair.index - minIndex;
                if (i == 0) {
                    first = currIndex;
                }
                if (i == size - 1) {
                    last = currIndex;
                }
                if (currNode.left != null) {
                    queue.offer(new Pair<>(currNode.left, 2 * currIndex + 1));
                }
                if (currNode.right != null) {
                    queue.offer(new Pair<>(currNode.right, 2 * currIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);


        }
        return maxWidth;
    }
}



