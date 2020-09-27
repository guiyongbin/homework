/**
 * 541号题
 * 反转字符串 II
 * <p>
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class homework2 {

    public String reverseStr(String s, int k) {


        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i = i + 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, chars.length - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;

            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {

        homework2 w = new homework2();
        String s = "abcdefg";

        System.out.println(w.reverseStr(s, 2));
    }

}
