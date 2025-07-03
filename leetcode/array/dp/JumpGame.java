package leetcode.array.dp;

import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {

    }

    //55. Jump Game
    boolean canReach(int[] arr) {
        int reachable = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + arr[i]);
        }
        return true;
    }

    //45. Jump Game II

    int findMinJumps(int[] arr) {
        int[] dpTable = new int[arr.length];
        Arrays.fill(dpTable, -1);
        return recMinJump(0, arr, dpTable);
    }

    int recMinJump(int i, int[] arr, int[] dpTable) {
        if (i >= arr.length - 1) {
            return 0;
        }
        if (dpTable[i] != -1) {
            return dpTable[i];
        }
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i]; j++) {
            if (i + j < arr.length) {
                int jumps = recMinJump(i + j, arr, dpTable);
                if (jumps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + jumps);
                }
            }
        }
        dpTable[i] = minJumps;
        return minJumps;
    }
}
