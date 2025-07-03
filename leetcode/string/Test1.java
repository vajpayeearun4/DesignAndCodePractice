package leetcode.string;

import java.util.HashMap;
import java.util.Map;

//Longest Substring with At Most K Distinct Characters
public class Test1 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        Map<Character, Integer> freqMap = new HashMap<>();
        int left =0;
        int maxLength = 0;
        for(int right = 0;right < s.length(); right++){
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            while(freqMap.size() > k){
                if(freqMap.containsKey(s.charAt(left))){
                   if(freqMap.get(s.charAt(left)) == 1){
                       freqMap.remove(s.charAt(left));
                   } else {
                       freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                   }

                   left++;
                }
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        System.out.println(maxLength);
    }
}
