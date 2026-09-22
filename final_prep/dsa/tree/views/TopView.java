package final_prep.dsa.tree.views;

import final_prep.dsa.tree.TreeNode;
import org.w3c.dom.Node;

import java.util.*;

public class TopView {
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(TreeNode root) {
        // code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        Map<Integer, Integer> hdMap = new LinkedHashMap<>();
        int minHD = Integer.MAX_VALUE;
        int maxHD = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i<levelSize; i++) {
                Pair pair = queue.poll();
                TreeNode currNode = pair.node;
                minHD = Math.min(minHD, pair.hd);
                maxHD = Math.max(maxHD, pair.hd);
                if (!hdMap.containsKey(currNode.val)) {
                    hdMap.put(currNode.val, pair.hd);
                }
                if (currNode.left != null) {
                    queue.offer(new Pair(currNode.left, pair.hd - 1));
                }
                if (currNode.right != null) {
                    queue.offer(new Pair(currNode.right, pair.hd + 1));
                }
            }
        }
        for (int i= minHD; i<= maxHD; i++) {
            result.add(hdMap.get(i));
        }
        return result;

    }
}
