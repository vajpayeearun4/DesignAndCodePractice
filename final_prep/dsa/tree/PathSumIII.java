package final_prep.dsa.tree;

import java.util.HashMap;
import java.util.Map;

/*
437. Path Sum III
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0L, 1);
        return calcPathSumRec(root, targetSum, 0, prefixCountMap);
    }

    int calcPathSumRec(TreeNode root, int targetSum, long currSum, Map<Long, Integer> prefixCountMap){
        if(root == null){
            return 0;
        }
        currSum+=root.val;
        long required = currSum-targetSum;
        int count = prefixCountMap.getOrDefault(required, 0);
        prefixCountMap.put(currSum, prefixCountMap.getOrDefault(currSum, 0)+1);
        count+=calcPathSumRec(root.left, targetSum, currSum, prefixCountMap);
        count+=calcPathSumRec(root.right, targetSum, currSum, prefixCountMap);
        prefixCountMap.put(currSum,prefixCountMap.get(currSum)-1 );
        return count;
    }
}
