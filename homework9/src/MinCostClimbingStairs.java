import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= len; i++) {

            int a = dp[i - 1] + cost[i - 1];
            int b = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(a, b);

        }
        return dp[len];
    }
}
