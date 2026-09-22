package final_prep.dsa.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStr {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (stMap.containsKey(sch) && stMap.get(sch) != tch) {
                return false;
            }
            if (tsMap.containsKey(tch) && tsMap.get(tch) != sch) {
                return false;
            }
            stMap.put(sch, tch);
            tsMap.put(tch, sch);

        }
        return true;
    }
}
