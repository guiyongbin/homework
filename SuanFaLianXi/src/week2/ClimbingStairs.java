package week2;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 爬楼梯
 */
public class ClimbingStairs {

    static class Soution1 {

        public int climbStairs(int n) {
            int[] memo = new int[n + 1];
            return climbMemoStairs(n, memo);
        }

        private int climbMemoStairs(int n, int[] memo) {
            if (memo[n] > 0) {
                return memo[n];
            } else if (n == 1) {
                memo[n] = 1;
            } else if (n == 2) {
                memo[n] = 2;
            } else {
                memo[n] = climbMemoStairs(n - 1, memo) + climbMemoStairs(n - 2, memo);
            }
            return memo[n];
        }


    }

    static class Solution2 {


        public int climbStairs(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            }

            int a = 1;
            int b = 2;
            int sum = 0;
            for (int i = 2; i < n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return sum;
        }
    }


}
