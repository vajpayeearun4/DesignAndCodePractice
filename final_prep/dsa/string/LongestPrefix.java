package final_prep.dsa.string;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
