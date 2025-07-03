package leetcode.array;

import java.util.Arrays;

//135. Candy
public class Candy {

    public static void main(String[] args) {

    }

    int findTotalMinCandies(int[] ratings) {
        int n = ratings.length;
        int[] candyArr = new int[n];
        Arrays.fill(candyArr, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyArr[i] = candyArr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyArr[i] = Math.max(candyArr[i], candyArr[i + 1] + 1);
            }
        }
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candyArr[i];
        }
        return totalCandies;
    }
}
