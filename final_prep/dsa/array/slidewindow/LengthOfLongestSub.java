package final_prep.dsa.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSub {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int length = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            length++;
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            if (freqMap.size() == length) {
                maxLength = Math.max(maxLength, length);
            } else {
                Character leftElem = s.charAt(i + 1 - length);
                length--;
                freqMap.put(leftElem, freqMap.get(leftElem) - 1);
                if (freqMap.get(leftElem) == 0) {
                    freqMap.remove(leftElem);
                }
            }
        }
        return maxLength;
    }
}
