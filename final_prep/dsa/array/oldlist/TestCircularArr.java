package final_prep.dsa.array.oldlist;

public class TestCircularArr {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int n = nums.length;
        for (int i = 0; i < 2 * n; i++) {
            System.out.println(nums[i % n]);
        }
    }
}
