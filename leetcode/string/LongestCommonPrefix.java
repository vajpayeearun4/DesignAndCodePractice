package leetcode.string;

import java.util.Arrays;

//14. Longest Common Prefix
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int i=0;
        while(i < first.length() && i< last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }
        return first.substring(0, i);
    }
}
