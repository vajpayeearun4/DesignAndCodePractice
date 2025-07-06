package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. Letter Combinations of a Phone Number
public class LetterCombOfPhoneNumber {
    private static final Map<Character, String> phoneMap = Map.of(
            '2', "abc", '3', "def",
            '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs",
            '8', "tuv", '9', "wxyz"
    );

    public static void main(String[] args) {

    }

    List<String> findComb(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    void dfs(String digits, int index, List<String> result, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < letters.toCharArray().length; i++) {
            path.append(letters.charAt(i));
            dfs(digits, index + 1, result, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
