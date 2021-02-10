import java.util.HashMap;
import java.util.Hashtable;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 72 编辑距离
 */
public class EditDistance {


    HashMap map = new HashMap();
    Hashtable ta = new Hashtable();
    public int minDistance(String word1, String word2) {
        int hang = word1.length() + 1;
        int lie = word2.length() + 1;

        if (hang * lie == 1) {
            return word1.length() + word2.length();
        }

        int[][] dp = new int[hang][lie];
        for (int i = 0; i < hang; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < lie; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);

                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (a != b) {
                    left += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[hang - 1][lie - 1];


    }
}
