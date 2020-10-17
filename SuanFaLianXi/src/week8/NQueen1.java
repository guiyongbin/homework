package week8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/description/
 * n 皇后
 */
public class NQueen1 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solution = new ArrayList<>();

        int[] queen = new int[n];

        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagnoal1 = new HashSet<>();
        HashSet<Integer> diagnoal2 = new HashSet<>();

        int row = 0;

        backTrace(solution, queen, n, row, columns, diagnoal1, diagnoal2);
        return solution;
    }

    private void backTrace(List<List<String>> solution, int[] queen, int n, int row, HashSet<Integer> columns, HashSet<Integer> diagnoal1, HashSet<Integer> diagnoal2) {

        if (n == row) {
            List<String> list = generate(queen, n);
            solution.add(list);
        } else {
            for (int i = 0; i < n; i++) {

                if (columns.contains(i)) {
                    continue;
                }

                int diag1 = row - i;
                if (diagnoal1.contains(diag1)) {
                    continue;
                }

                int diag2 = row + i;
                if (diagnoal2.contains(diag2)) {
                    continue;
                }
                queen[row] = i;
                columns.add(i);
                diagnoal1.add(diag1);
                diagnoal2.add(diag2);



                backTrace(solution, queen, n, row + 1, columns, diagnoal1, diagnoal2);
                queen[row] = -1;

                columns.remove(i);
                diagnoal1.remove(diag1);
                diagnoal2.remove(diag2);

            }

        }
    }

    private List<String> generate(int[] queen, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queen[i]] = 'Q';
            list.add(new String(chars));
        }

        return list;
    }


}
