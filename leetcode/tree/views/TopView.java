package leetcode.tree.views;

import leetcode.tree.Pair;
import leetcode.tree.TreeNode;

import java.util.*;

public class TopView {

    public static void main(String[] args) {

    }

    List<Integer> topView(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        Map<Integer, Integer> hdMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currPair = queue.poll();
            TreeNode currNode = currPair.node;
            int hd = currPair.index;
            hdMap.putIfAbsent(hd, currNode.val);
            if (currNode.left != null) {
                queue.offer(new Pair<>(currNode.left, hd - 1));
            }
            if (currNode.right != null) {
                queue.offer(new Pair<>(currNode.right, hd + 1));
            }
        }
        return hdMap.values().stream().toList();
    }
}
