package final_prep.dsa.string;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWords {

    public String reverseWords(String input) {
        StringBuilder builder = new StringBuilder();
        int right = input.length() - 1;
        while (right >= 0) {

            while (right >= 0 && input.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) {
                break;
            }
            int left = right;
            while (left >= 0 && input.charAt(left) != ' ') {
                left--;
            }
            if (builder.length() > 0) {
                builder.append(' ');
            }
            builder.append(input, left + 1, right + 1);
            right = left - 1;
        }

        return builder.toString();
    }
}
