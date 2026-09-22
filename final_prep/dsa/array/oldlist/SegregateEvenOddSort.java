package final_prep.dsa.array.oldlist;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/problems/segregate-even-and-odd-numbers4629/1
 */
public class SegregateEvenOddSort {
    void segregateEvenOdd(int arr[]) {
        // code here
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            while (left <= right && arr[left] % 2 == 0) {
                left++;
            }
            while (left <= right && arr[right] % 2 != 0) {
                right--;
            }
            if (left <= right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        int evenEnd = left;
        Arrays.sort(arr, 0, left);
        Arrays.sort(arr, left, n);

    }
}
