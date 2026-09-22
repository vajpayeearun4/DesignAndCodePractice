package final_prep.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrderTrav {
    static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Pair> nodes = new ArrayList<>();
        dfs(root, nodes, 0, 0);
        nodes.sort((a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }
            if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            }

            return Integer.compare(a.node.val, b.node.val);

        });

        int prevCol = Integer.MIN_VALUE;
        for (Pair pair : nodes) {
            if (prevCol != pair.col) {
                result.add(new ArrayList<>());
                prevCol = pair.col;
            }
            result.get(result.size() - 1).add(pair.node.val);
        }

        return result;

    }

    void dfs(TreeNode root, List<Pair> nodes, int row, int col) {
        if (root == null) {
            return;
        }
        nodes.add(new Pair(root, row, col));
        dfs(root.left, nodes, row + 1, col - 1);
        dfs(root.right, nodes, row + 1, col + 1);
    }
}
