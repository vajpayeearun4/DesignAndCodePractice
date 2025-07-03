package leetcode.tree.views;

import com.sun.source.tree.Tree;
import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {

    public static void main(String[] args) {

    }

    void leftView(TreeNode root, List<Integer> result, int currLevel) {
        if (root == null) {
            return;
        }
        if (currLevel == result.size()) {
            result.add(root.val);
        }
        leftView(root.left, result, currLevel + 1);
        leftView(root.right, result, currLevel + 1);
    }

    List<Integer> usingBFS(TreeNode root, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return result;
    }
}
