package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {

    }

    //383. Ransom Note
    boolean canConstruct(String ransom, String magazine){
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        for (char ch : ransom.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch)-1);
                if (freqMap.get(ch) == 0){
                    freqMap.remove(ch);
                }
            }else {
                return false;
            }

        }
        return true;
    }
}
