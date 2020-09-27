import sun.nio.cs.ext.MS874;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class homework1 {


    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s == "") {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? -1 : 0;
        }

        int index = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (map.size() > 0 && map.get(c) != null) {
                continue;
            }

            boolean exist = exist(s, c, i + 1);
            if (!exist) {
                return i;
            } else {
                map.put(c, i);
            }
        }

        return index;
    }

    private boolean exist(String s, char c, int start) {
        for (int j = start; j < s.length(); j++) {
            if (s.charAt(j) == c) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        homework1 w = new homework1();
        String s = "leetcode";

        String s1 = "loveleetcode";
        String s2 = "cc";
        String s3 = "cnc";
        String s4 = "z";
        System.out.println(w.firstUniqChar(s4));

    }


}
