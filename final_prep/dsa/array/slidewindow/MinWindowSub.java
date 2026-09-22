package final_prep.dsa.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSub {

    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0, minStart = 0, have = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
            if (needMap.containsKey(s.charAt(right))
                    && needMap.get(s.charAt(right)).intValue() == windowMap.get(s.charAt(right)).intValue()) {
                have++;

            }
            while (have == needMap.size()) {
                int currLength = right - left + 1;
                if (currLength < minLength) {
                    minLength = currLength;
                    minStart = left;
                }
                Character leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (needMap.containsKey(leftChar) && windowMap.get(leftChar) < needMap.get(leftChar)) {
                    have--;
                }
                left++;

            }

        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}
