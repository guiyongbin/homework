/**
 * 64 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class homework1 {

    /**
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int hang = grid.length;
        int lie = grid[0].length;

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[hang - 1][lie - 1];
    }


    public static void main(String[] args) {

        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        homework1 h = new homework1();
        int i = h.minPathSum(arr);
        System.out.println("最小路径和：" + i);
    }
}
