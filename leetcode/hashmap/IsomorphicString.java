package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {

    }

    boolean isIsomorphic(String source, String destination){
        if (source.length()!=destination.length()) {
            return false;
        }
        Map<Character, Character> sdMap = new HashMap<>();
        Map<Character, Character> dsMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            Character sCh = source.charAt(i);
            Character dCh = destination.charAt(i);

            if(sdMap.containsKey(sCh)){
                if(sdMap.get(sCh)!=dCh){
                    return false;
                }
            } else {
                sdMap.put(sCh, dCh);
            }

            if(dsMap.containsKey(dCh)){
                if (dsMap.get(dCh)!=sCh) {
                    return false;
                }
            } else {
                dsMap.put(dCh, sCh);
            }

        }
        return true;
    }
}
