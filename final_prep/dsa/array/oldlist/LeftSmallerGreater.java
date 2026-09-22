package final_prep.dsa.array.oldlist;

public class LeftSmallerGreater {
    public int findElement(int[] arr) {
        // code here
        int n = arr.length;
        int[] rightMinArr = new int[n];

        rightMinArr[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMinArr[i] = Math.min(rightMinArr[i + 1], arr[i + 1]);
        }
        int leftMax = arr[0];
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax && arr[i] <= rightMinArr[i]) {
                return arr[i];
            }
            leftMax = Math.max(leftMax, arr[i]);
        }
        return -1;
    }
}
