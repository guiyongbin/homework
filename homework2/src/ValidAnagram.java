import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 242 有效的字母异位词
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);

        return Arrays.equals(schars,tchars);
    }
}
