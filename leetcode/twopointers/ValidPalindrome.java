package leetcode.twopointers;

public class ValidPalindrome {

    boolean isValid(String input){
        int left = 0;
        int right = input.length()-1;
        input = input.toLowerCase();
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))){
                right--;
            }

            while (left < right && input.charAt(left)!=input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
