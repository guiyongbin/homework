import java.util.HashMap;

public class homework2 {


    /**
     *
     * 根据字符串结尾的两个字符 推导转移方程
     *
     * 在定义状态的时候可以这样定义：dp[i] 以 s[i]结尾的前缀字符串有多少种解码方法
     * 如果 s[i] == '0' ，字符 s[i] 就不能单独解码，所以当 s[i] != '0' 时，dp[i] = dp[i - 1] * 1
     * 因为 A=1  J=10,  带0的必须是“J”
     *
     *如果当前字符可以和它前一个字符能够解码
     *如果当前字符和它前一个字符，能够解码，即 10 <= int(s[i - 1..i]) <= 26，即 dp[i] += dp[i - 2] * 1；
     *
     *  String str = "1234";
     *
     *  2可以和前面的字符1解码，   10<12<26
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i] = dp[i - 1];
            }
            //chars[i - 1]   chars[i]  取出i-1  和 i
            int num = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }

        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        homework2 h = new homework2();
        String str = "1234";
        int i = h.numDecodings(str);
        System.out.println("解码方法：" + i);


    }
}
