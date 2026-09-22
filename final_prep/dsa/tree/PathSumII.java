package final_prep.dsa.tree;

import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        buildPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    void buildPaths(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        int remaining = targetSum - root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (remaining == 0) {
                result.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        buildPaths(root.left, remaining, path, result);
        buildPaths(root.right, remaining, path, result);
        path.remove(path.size() - 1);
    }
}
