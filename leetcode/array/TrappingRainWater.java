package leetcode.array;

public class TrappingRainWater {

    public static void main(String[] args) {

    }

    int findTrappedWater(int[] heightArr){
        int water = 0;
        int n = heightArr.length;
        int[] leftMax = new int[n];
        int[] rightMax= new int[n];
        leftMax[0] = heightArr[0] ;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(heightArr[i], leftMax[i-1]);
        }
        rightMax[n-1]= heightArr[n-1];
        for (int i = n-2; i >=0; i--) {
            rightMax[i] = Math.max(heightArr[i], rightMax[i+1]);
        }
        for (int i = 0; i < heightArr.length; i++) {
            water+=Math.min(leftMax[i], rightMax[i])-heightArr[i];
        }
        return water;
    }
}
