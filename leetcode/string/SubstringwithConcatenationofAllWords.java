package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//30. Substring with Concatenation of All Words
public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {

    }

    List<Integer> findStartingIndex(String input, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int wordCount = words[0].length();
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordCount; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenMap = new HashMap<>();
            for (int right = i; right + wordCount <= input.length(); right += wordCount) {
                String foundWord = input.substring(right, right + wordCount);
                if (wordFreqMap.containsKey(foundWord)) {
                    seenMap.put(foundWord, seenMap.getOrDefault(foundWord, 0) + 1);
                    count++;
                    while (seenMap.get(foundWord) > wordFreqMap.get(foundWord)) {
                        String leftWord = input.substring(left, left + wordCount);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        if (seenMap.get(leftWord) == 0) {
                            seenMap.remove(leftWord);
                        }
                        left += wordCount;
                        count--;
                    }
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    seenMap.clear();
                    count = 0;
                    left = right + wordCount;
                }


            }

        }

        return result;
    }
}
