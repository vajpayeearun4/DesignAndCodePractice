package final_prep.dsa.string;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromSub {
    public String longestPalindrome(String inputStr) {
        int start = 0, end = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            // oddd length
            int[] oddArr = expand(inputStr, i, i);
            int[] evenArr = expand(inputStr, i, i + 1);

            if (oddArr[1] - oddArr[0] > end - start) {
                start = oddArr[0];
                end = oddArr[1];
            }
            if (evenArr[1] - evenArr[0] > end - start) {
                start = evenArr[0];
                end = evenArr[1];
            }


        }
        return inputStr.substring(start, end + 1);
    }

    int[] expand(String inputStr, int left, int right) {
        while (left >= 0 && right < inputStr.length() && inputStr.charAt(left) == inputStr.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
