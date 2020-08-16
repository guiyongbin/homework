import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Homework3 {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // k 不能等于n
        if (n <= 0 || k <= 0 || k > n) {
            return lists;
        }
        findCombine(n, k, 1, new Stack());
        return lists;
    }

    private void findCombine(int n, int k, int start, Stack<Integer> stack) {
        if (stack.size() == k) {
            List<Integer> integers = new ArrayList<>(stack);
            lists.add(integers);
            return;
        }
        for (int i = start; i <= n; i++) {
            stack.add(i);
            findCombine(n, k, i + 1, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Homework3 d = new Homework3();
        List<List<Integer>> combine = d.combine(4, 2);
        System.out.println(combine);
    }

}
