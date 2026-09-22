package final_prep.dsa.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String eachStr : strs) {
            int[] countArr = new int[26];
            for (char ch : eachStr.toCharArray()) {
                countArr[ch - 'a']++;
            }
            StringBuilder keyStr = new StringBuilder();
            for (int value : countArr) {
                keyStr.append("#");
                keyStr.append(value);
            }
            String key = keyStr.toString();
            if (groupMap.containsKey(key)) {
                groupMap.get(key).add(eachStr);
            } else {
                List<String> groupElList = new ArrayList<>();
                groupElList.add(eachStr);
                groupMap.put(key, groupElList);
            }

        }

        return new ArrayList<>(groupMap.values());
    }
}
