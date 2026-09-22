package final_prep.dsa.tree;

/*
1448. Count Good Nodes in Binary Tree
 */
public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return findGoodRec(root, root.val);
    }

    int findGoodRec(TreeNode root, int maxValue){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val >= maxValue){
            count = 1;
            maxValue = root.val;
        }
        count+=findGoodRec(root.left, maxValue);
        count+=findGoodRec(root.right, maxValue);
        return count;

    }
}
