/**
 * 位 1 的个数
 * 191号题
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class homework1 {

    /**
     * 将 n 和 n-1 进行与运算总能把n 中的最低位的1 变成0，并且保持其他位不变
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n =n& (n - 1);
        }
        return sum;
    }
}
