package final_prep.dsa.array.twopointer;

//https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
public class IsSubseq {
    public boolean isSubsequence(String s, String target) {
        int first = 0, second = 0;
        while (first < s.length() && second < target.length()) {
            while (second < target.length() && s.charAt(first) != target.charAt(second)) {
                second++;
            }
            if (first < s.length() && second < target.length() && s.charAt(first) == target.charAt(second)) {
                first++;
                second++;
            }
        }
        return first == s.length();
    }
}
