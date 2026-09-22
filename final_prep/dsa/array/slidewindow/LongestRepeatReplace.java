package final_prep.dsa.array.slidewindow;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatReplace {

    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];

        int left = 0;
        int maxLength = 0;
        int maxFreq=0;
        for(int right=0;right < s.length();right++){
            char ch = s.charAt(right);
            freqArr[ch-'A']++;
            maxFreq = Math.max(maxFreq,freqArr[ch-'A'] );
            while(right-left +1 - maxFreq > k){
                char leftChar = s.charAt(left);
                freqArr[leftChar-'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left +1);

        }
        return maxLength;

    }
}
