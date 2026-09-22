package final_prep.dsa.tree;

/*
129. Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return buildNumberThenSum(root, 0);
    }

    int buildNumberThenSum(TreeNode root, int currentNumber){
        if(root == null){
            return 0;
        }
        currentNumber = currentNumber*10 + root.val;
        if(root.left == null && root.right == null){
            return currentNumber;
        }

        return buildNumberThenSum(root.left, currentNumber) + buildNumberThenSum(root.right, currentNumber);
    }
}
