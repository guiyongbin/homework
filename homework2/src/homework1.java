import java.util.Arrays;

/**
 *
 * 异位词
 * 字母出现的次数都是一样的，但是顺序不一样
 */
public class homework1 {

    public boolean isAnagram1(String s, String t) {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1,chars2);
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        // 同样的字母 在 counter 里出现的索引的位置必然是一样的，所以如果
        //出现频次相同，那么 counter 对应出现的索引的值会 ++ -- 之后变成0

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
