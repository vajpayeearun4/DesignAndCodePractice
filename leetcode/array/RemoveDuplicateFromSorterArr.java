package leetcode.array;

//26. Remove Duplicates from Sorted Array
public class RemoveDuplicateFromSorterArr {

    public static void main(String[] args) {

    }

    int removeDuplicates(int[] arr) {
        int i = 0;
        int k = 0;
        while (i < arr.length) {
            while (i < arr.length-1 && arr[i] == arr[i + 1]) {
                i++;
            }
            arr[k++] = arr[i++];
        }
        return k;
    }
}
