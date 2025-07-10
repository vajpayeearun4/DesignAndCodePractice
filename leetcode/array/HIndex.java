package leetcode.array;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {

    }

    int findCitations(int[] citations){
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            int h = n-i;
            if (citations[i]>=h) {
                return h;
            }
        }
        return 0;
    }
}
