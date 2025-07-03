package leetcode.array;

import java.util.Arrays;

//189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3,4,5,6,7};
        int k = 3;
        int n = arr.length;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        Arrays.stream(arr).forEach(System.out :: println);
    }

    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            start++;
            end--;
        }
    }
}
