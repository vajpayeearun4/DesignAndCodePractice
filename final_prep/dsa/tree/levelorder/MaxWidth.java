package final_prep.dsa.tree.levelorder;

import final_prep.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int firstIndex = queue.peek().index;
            int lastIndex = firstIndex;
            int currentWidth = 0;
            for (int i = 0; i < levelSize; i++) {
                Pair currentPair = queue.poll();
                TreeNode currentNode = currentPair.node;
                lastIndex = currentPair.index;
                if (currentNode.left != null) {
                    queue.offer(new Pair(currentNode.left, 2 * currentPair.index + 1));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair(currentNode.right, 2 * currentPair.index + 2));
                }
            }
            currentWidth = lastIndex - firstIndex + 1;
            maxWidth = Math.max(currentWidth, maxWidth);

        }
        return maxWidth;
    }
}
