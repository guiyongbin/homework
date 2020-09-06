/**
 * https://leetcode-cn.com/problems/maximal-square/submissions/
 *
 * 221 最大正方形
 */
public class homework3 {


    /**
     *（1） 如果当前元素在第0行或者第0列， 当前元素的dp 值只可能是1
     *
     *（2） 如果该位置是1，dp(i,j)的值由其上方，左边和左上方的三个相邻位置的 dp值决定
     * dp(i,j) = min[ dp(i-1,j), dp(i-1,j-1), dp9i,j-1) ]+1
     *
     * 时间复杂度 O（mn)
     * 空间复杂度 O(mn)
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int hang = matrix.length;
        int lie = matrix[0].length;

        int maxSlide = 0;
        int[][] dp = new int[hang][lie];

        for (int i = 0; i < hang; i++) {

            for (int j = 0; j < lie; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSlide = Math.max(dp[i][j], maxSlide);

                }

            }

        }

        return maxSlide * maxSlide;
    }


    public static void main(String[] args) {
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '0','1','1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };

        homework3 h = new homework3();
        int i = h.maximalSquare(arr);
        System.out.println("最大正方形面积是：" + i);

    }
}
