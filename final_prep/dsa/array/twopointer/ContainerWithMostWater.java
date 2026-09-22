package final_prep.dsa.array.twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currArea = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
