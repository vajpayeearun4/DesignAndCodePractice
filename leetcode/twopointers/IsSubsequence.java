package leetcode.twopointers;

public class IsSubsequence {

    boolean isSubsequence(String source, String target) {
        int a = 0;
        int b = 0;

        while (a < source.length() && b < target.length()) {
            if (source.charAt(a) == target.charAt(b)) {
                a++;
                b++;
            } else {
                b++;
            }
        }
        return a == source.length();
    }
}
