/**
 * 300 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class homework3 {


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                        maxVal = Math.max(maxVal,dp[j]);
                }
            }
            dp[i]=maxVal+1;
            maxans = Math.max(maxans,dp[i]);

        }

        return maxans;
    }
}
