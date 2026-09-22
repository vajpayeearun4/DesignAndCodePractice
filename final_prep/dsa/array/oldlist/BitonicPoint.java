package final_prep.dsa.array.oldlist;

public class BitonicPoint {
    public int findMaximum(int[] arr) {
        // code here
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                high = mid;
            }
        }

        return arr[low];
    }
}
