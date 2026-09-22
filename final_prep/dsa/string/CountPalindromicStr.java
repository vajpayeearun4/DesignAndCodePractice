package final_prep.dsa.string;

//https://leetcode.com/problems/palindromic-substrings/submissions/2147374981/
public class CountPalindromicStr {

    public int countSubstrings(String inputStr) {
        int count = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            count += expand(inputStr, i, i);
            count += expand(inputStr, i, i + 1);
        }
        return count;
    }

    int expand(String inputStr, int left, int right) {
        int count = 0;
        while (left >= 0 && right < inputStr.length() && inputStr.charAt(left) == inputStr.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
