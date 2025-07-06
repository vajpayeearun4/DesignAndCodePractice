package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreAndIn {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIndex = 0;
    public static void main(String[] args) {

    }

    public TreeNode build(int[] preOrderArr , int[] inOrderArr){
        for (int i = 0; i < inOrderArr.length; i++) {
            inorderMap.put(inOrderArr[i], i);
        }
        return buildFromPre(preOrderArr, 0, preOrderArr.length-1);
    }

    public TreeNode buildFromPre(int[] preorderArr, int start, int end){
        if (preorderArr.length == preorderIndex || start > end) {
            return null;
        }
        int val = preorderArr[preorderIndex++];
        TreeNode node = new TreeNode(val);
        int inorderIndex = inorderMap.get(val);
        node.left = buildFromPre(preorderArr, start, inorderIndex-1);
        node.right = buildFromPre(preorderArr, inorderIndex+1, end);
        return node;
    }
}
