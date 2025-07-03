package leetcode.array;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

    }
    //238. Product of Array Except Self
    int[] findProduct(int[] arr){
        int n = arr.length;
        int[] rightProdArr = new int[n];
        rightProdArr[n-1] = 1;
        for (int i = n-2; i>=0 ; i--) {
            rightProdArr[i] = rightProdArr[i+1]*arr[i+1];
        }
        int leftProd = 1;
        for (int i = 0; i < n; i++) {
            rightProdArr[i]=leftProd*rightProdArr[i];
            leftProd*=arr[i];
        }

        return rightProdArr;
    }
}
