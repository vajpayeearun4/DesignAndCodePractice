package final_prep.dsa.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

/*
567. Permutation in String
 */
public class PermInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int k = s1.length();
        // create k size window of s2;
        int left = 0;
        int required = 0;
        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for (Character ch : s1.toCharArray()) {
            s1FreqMap.put(ch, s1FreqMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (s1FreqMap.containsKey(ch) && (s1FreqMap.get(ch) == windowMap.get(ch))) {
                required++;
            }

        }
        if (required == s1FreqMap.size()) {
            return true;
        }
        for (int right = k; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (s1FreqMap.containsKey(ch) && (s1FreqMap.get(ch) == windowMap.get(ch))) {
                required++;
            }
            ch = s2.charAt(left);

            if (s1FreqMap.containsKey(ch) && (windowMap.get(ch) == s1FreqMap.get(ch))) {
                required--;
            }
            windowMap.put(ch, windowMap.get(ch) - 1);
            left++;
            if (required == s1FreqMap.size()) {
                return true;
            }
        }
        return false;
    }
}
