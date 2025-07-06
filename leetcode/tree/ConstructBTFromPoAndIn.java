package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPoAndIn {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int postOrderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {


        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postOrderIndex = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }


    TreeNode build(int[] postOrderArr, int start, int end) {
        if (postOrderIndex < 0 || start > end) {
            return null;
        }
        int val = postOrderArr[postOrderIndex--];
        TreeNode node = new TreeNode(val);
        int inorderIndex = inorderMap.get(val);
        node.right = build(postOrderArr, inorderIndex + 1, end);
        node.left = build(postOrderArr, start, inorderIndex - 1);
        return node;
    }
}
