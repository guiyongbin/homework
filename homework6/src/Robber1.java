/**
 * 打家劫舍1
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Robber1 {

    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        if(len==1){
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){

            dp[i] =Math.max(dp[i-2]+nums[i],dp[i]);
        }

        return dp[len-1];
    }
}
