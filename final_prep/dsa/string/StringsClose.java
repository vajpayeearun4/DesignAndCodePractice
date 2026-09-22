package final_prep.dsa.string;

import java.util.Arrays;

//https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
public class StringsClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();
        int[] count1Arr = new int[26];
        int[] count2Arr = new int[26];
        for (int i = 0; i < n; i++) {
            count1Arr[word1.charAt(i) - 'a']++;
            count2Arr[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((count1Arr[i] == 0) != (count2Arr[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(count1Arr);
        Arrays.sort(count2Arr);
        return Arrays.equals(count1Arr, count2Arr);
    }
}
