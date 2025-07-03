package leetcode.array;

//80. Remove Duplicates from Sorted Array II
public class RemoveDuplicateFromSorterArrII {

    public static void main(String[] args) {

    }

    int removeDuplicates(int[] arr) {
        int i = 0;
        int k = 0;
        while (i < arr.length) {
            while (i < arr.length-2 && arr[i] == arr[i + 2]) {
                i++;
            }
            arr[k++] = arr[i++];
        }
        return k;
    }
}
