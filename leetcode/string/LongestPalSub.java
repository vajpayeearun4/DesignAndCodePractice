package leetcode.string;

// Longest Palindromic Substring
public class LongestPalSub {

    public static void main(String[] args) {

    }

    String longestPalindromicSub(String input) {
        int start = 0, end = 0;
        for (int i = 0; i < input.length(); i++) {
            int oddLength = expandAroundCenter(input, i, i);
            int evenLength = expandAroundCenter(input, i, i + 1);
            int len = Math.max(oddLength, evenLength);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return input.substring(start, end + 1);
    }

    int expandAroundCenter(String input, int left, int right) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return right - left + 1;
    }
}
