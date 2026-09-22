package final_prep.dsa.array.oldlist;

public class Count1s {
    public int countOnes(int[] arr) {
        // code here
        int low = 0, high = arr.length-1;
        int ans = -1;
        while(low<=high){

            int mid = (low+high)/2;
            if(arr[mid] == 1){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans+1;
    }
}
