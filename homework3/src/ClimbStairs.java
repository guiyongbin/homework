/**
 * 70 爬楼梯
 *
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {


    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbHelper(n, memo);
    }

    private int climbHelper(int n, int[] memo) {

        if(memo[n]>0){
            return memo[n];
        }
        if(n==1){
            memo[n]=1;
        }else if(n==2){
            memo[n]=2;
        }else {
            memo[n] = climbHelper(n-1,memo)+climbHelper(n-2,memo);
        }
        return memo[n];
    }

}
