package final_prep.dsa.tree;

/*
235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root ==q){
            return root;
        }
        TreeNode left=null;
        if(p.val < root.val && q.val < root.val){
            left =  lowestCommonAncestor(root.left, p, q);
        }
        TreeNode right=null;
        if(p.val > root.val && q.val > root.val){
            right=  lowestCommonAncestor(root.right , p, q);
        }
        if(p.val < root.val && q.val > root.val || (q.val < root.val && p.val > root.val)){
            return root;
        }
        return left!=null ? left: right;
    }

}
