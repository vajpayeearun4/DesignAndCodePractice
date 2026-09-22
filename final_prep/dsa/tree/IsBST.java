package final_prep.dsa.tree;

/*

 */
public class IsBST {
    public boolean isValidBST(TreeNode root) {
        return checkIfBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkIfBST(TreeNode root, long min , long max){
        if(root == null ){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return checkIfBST(root.left, min, root.val) && checkIfBST(root.right, root.val , max);
    }
}
