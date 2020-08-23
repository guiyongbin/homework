/**
 * 搜索二维矩阵数组
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class homework3 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else {
                if (target > midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
