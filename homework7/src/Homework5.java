import java.util.*;

/**
 * 51  N 皇后问题
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Homework5 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();

        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diag1 = row - i;
                if(diagonals1.contains(diag1)){
                    continue;
                }
                int diag2 = row+i;
                if(diagonals2.contains(diag2)){
                    continue;
                }

                queens[row]=i;
                columns.add(i);
                diagonals1.add(diag1);
                diagonals2.add(diag2);
                backtrack(solutions,queens,n,row+1,columns,diagonals1,diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diag1);
                diagonals2.remove(diag2);

            }

        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]]='Q';
            board.add(new String(row));
        }

        return board;
    }
}
