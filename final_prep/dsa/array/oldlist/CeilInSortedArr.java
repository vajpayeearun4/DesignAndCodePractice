package final_prep.dsa.array.oldlist;

public class CeilInSortedArr {
    public int findCeil(int[] arr, int x) {
        // code here
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (x <= arr[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
