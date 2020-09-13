/**
 * 70 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/solution/
 */
public class Homework1 {
    /**
     * 带有 缓存的减枝
     *
     */
    static class Function1 {

        /**
         *时间复杂度 O(n)
         * 空间复杂度 O(n)
         */
        public int climbStairs(int n) {
            int[] memon = new int[n + 1];
            return climbStairsMemo(n, memon);
        }

        public int climbStairsMemo(int n, int memo[]) {
            if (memo[n] > 0) {
                return memo[n];
            }
            if (n == 1) {
                memo[n] = 1;
            } else if (n == 2) {
                memo[n] = 2;
            } else {
                memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
            }
            return memo[n];
        }

    }

    /**
     * 动态规划
     * 时间复杂度 O(n)
     * 空间复杂度o(n)
     */
    static class Function2 {


        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }


}
