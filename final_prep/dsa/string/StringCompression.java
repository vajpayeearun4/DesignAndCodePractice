package final_prep.dsa.string;

//https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
public class StringCompression {

    public int compress(char[] chars) {
        int read = 0, write = 0;
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                count++;
                read++;
            }
            chars[write++] = current;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        return write;
    }
}
