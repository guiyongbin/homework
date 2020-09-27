/**
 * 5 最长回文串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class homework4 {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String ans = "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int temp = j + i;

                if (i == 0) {
                    dp[j][temp] = true;
                } else if (i == 1) {
                    dp[j][temp] = (s.charAt(j) == s.charAt(temp));
                } else {
                    dp[j][temp] = (s.charAt(j) == s.charAt(temp) && dp[j + 1][temp - 1]);
                }
                if (dp[j][temp] && (i + 1 > ans.length())) {
                    ans = s.substring(j, j + i + 1);
                }

            }
        }
        return ans;
    }
}
