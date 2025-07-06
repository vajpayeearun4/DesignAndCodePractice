package leetcode.tree;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {

    }

    //Leetcode 116: Populating Next Right Pointers in Each Node (I)
    TreeNode connect(TreeNode root) {
        if (root == null) return null;
        TreeNode levelStart = root;
        while (levelStart.left != null) {
            TreeNode firstNode = levelStart;
            while (firstNode != null) {
                firstNode.left.next = firstNode.right;
                if (firstNode.next != null) {
                    firstNode.right.next = firstNode.next.left;
                }
                firstNode = firstNode.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    // Leetcode 117. Populating Next Right Pointers in Each Node II
    TreeNode connectNotPerfectTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode curr = root;
        while (curr != null) {
            TreeNode dummy = new TreeNode(0);
            TreeNode tail = dummy;
            while (curr != null) {
                if (curr.left!=null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right!=null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }

    //515. Find Largest Value in Each Tree Row
    public static class LargestInEachRowBT {

        List<Integer> findLargest(TreeNode root){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode currNode = queue.poll();
                    max = Math.max(max, currNode.val);
                    if (currNode.left!=null) {
                        queue.offer(currNode.left);
                    }
                    if (currNode.right!=null) {
                        queue.offer(currNode.right);
                    }
                }
                result.add(max);
            }
            return result;
        }
    }

    //235. Lowest Common Ancestor of a Binary Search Tree
    public static class LCABST {

        TreeNode findLCABST(TreeNode root, int key1, int key2) {
            if (root == null) {
                return null;
            }
            if (key1 < root.val && key2 < root.val) {
                return findLCABST(root.left, key1, key2);
            }
            if (key1 > root.val && key2 > root.val) {
                return findLCABST(root.right, key1, key2);
            }
            return root;
        }
    }

    public static class MinDepthOfBT {

        int findMinDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lh = findMinDepth(root.left);
            int rh = findMinDepth(root.right);
            if (root.left != null && root.right != null) {
                return 1 + Math.min(lh, rh);
            }
            return lh != 0 ? lh + 1 : rh + 1;
        }
    }

    //437. Path Sum III
    public static class PathSumIII {

        public static void main(String[] args) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            TreeNode root = null;
            int targetSum = 10;
            findPathSum(root, 0, targetSum,sumMap);
        }

        static int findPathSum(TreeNode root,int currSum,  int targetSum, Map<Integer, Integer> sumMap) {
            if (root == null){
                return 0;
            }
            currSum+=root.val;

            int count = sumMap.getOrDefault(currSum-targetSum, 0);
            sumMap.put(currSum, sumMap.getOrDefault(currSum, 0)+1);
            count+=findPathSum(root.left, currSum, targetSum, sumMap);
            count+=findPathSum(root.right, currSum, targetSum, sumMap);
            sumMap.put(currSum, sumMap.getOrDefault(currSum, 0)-1);
            return count;
        }
    }
}


