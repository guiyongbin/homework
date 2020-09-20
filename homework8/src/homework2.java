public class homework2 {

    /**
     * 最原始的方法
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }


}
