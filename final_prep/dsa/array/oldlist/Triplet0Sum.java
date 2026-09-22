package final_prep.dsa.array.oldlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet0Sum {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 2; i++) {
                int start = i + 1, end = n - 1;
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while(start < end){
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            return result;
        }
}
