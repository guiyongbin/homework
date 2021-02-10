/**
 *打家劫舍2
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 */
public class Robber2 {

    public int rob(int[] nums) {

        int len = nums.length;
        if(len<2){
            return nums[0];
        }

        if(len<3){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        if (dp[len - 2] > dp[len - 3] + nums[len - 1]) {
            return dp[len - 2];
        } else {
            int max = dp[len - 2];
            dp[len - 1] = nums[len - 1];
            dp[len - 2] = nums[len - 1];
            for (int i = len - 3; i > 0; i--) {
                dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
            }
            return Math.max(max, dp[1]);
        }
    }
}
