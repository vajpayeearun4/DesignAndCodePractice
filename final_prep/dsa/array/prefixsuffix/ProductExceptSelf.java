package final_prep.dsa.array.prefixsuffix;

//https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int prefixProd = 1;
        for(int i=0;i<n;i++){
            answer[i] = prefixProd;
            prefixProd*=nums[i];
        }
        int suffixProd = 1;
        for(int i=n-1;i>=0;i--){
            answer[i]*=suffixProd;
            suffixProd*=nums[i];
        }
        return answer;
    }
}
