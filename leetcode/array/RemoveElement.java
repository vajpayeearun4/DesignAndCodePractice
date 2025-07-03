package leetcode.array;

//27. Remove Element
public class RemoveElement {

    public static void main(String[] args) {

    }

    int removeElement(int[] arr, int val){
        int k = 0;
        int i =0;
        while (i < arr.length){
            while(arr[i] == val){
                i++;
            }
            arr[k++] = arr[i++];
        }
        return k+1;
    }
}
