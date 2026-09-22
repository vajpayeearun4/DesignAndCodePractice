package final_prep.dsa.tree;

import java.util.HashMap;
import java.util.Map;

/*
105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConsBTFromInPr {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeWithInPre(preorder, 0, preorder.length - 1);
    }

    TreeNode buildTreeWithInPre(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootIndex = inorderMap.get(preorder[preorderIndex]);
        TreeNode rootNode = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        rootNode.left = buildTreeWithInPre(preorder, left, rootIndex - 1);
        rootNode.right = buildTreeWithInPre(preorder, rootIndex + 1, right);
        return rootNode;


    }
}
