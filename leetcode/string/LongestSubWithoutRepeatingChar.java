package leetcode.string;

import java.util.HashSet;
//3. Longest Substring Without Repeating Characters
public class LongestSubWithoutRepeatingChar {

    public static void main(String[] args) {

    }

    int findLength(String input) {
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < input.length(); right++) {
            char ch = input.charAt(right);
            while (charSet.contains(ch) && left < right) {
                charSet.remove(input.charAt(left));
                left++;
            }
            charSet.add(ch);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
