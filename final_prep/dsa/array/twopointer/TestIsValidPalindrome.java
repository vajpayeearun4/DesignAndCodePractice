package final_prep.dsa.array.twopointer;

public class TestIsValidPalindrome {

    public static void main(String[] args) {
        String input = "";

    }

    boolean isValidPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
