package final_prep.dsa.tree.levelorder;

import final_prep.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
958 — Check Completeness of a Binary Tree
 */
public class CompletenessofBT {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean seenNull = false;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                seenNull = true;
                continue;
            }

            // We already saw a gap,
            // but now found a real node.
            if (seenNull) {
                return false;
            }

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return true;
    }
}
