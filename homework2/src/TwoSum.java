/**
 * 1 两数之和
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
       int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for(int q=i+1;q<nums.length;q++){
                if(nums[i]+nums[q] == target){
                    arr[0]=i;
                    arr[1]=q;
                    break;
                }
            }
        }
        return arr;
    }
}
