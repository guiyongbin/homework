import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 全排列2
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Homework5 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        Arrays.sort(nums);

        int n = nums.length;
        boolean[] used = new boolean[n];
        Deque<Integer> path = new ArrayDeque<>(n);
        dfs(nums, n, 0, path, used, list);
        return list;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> list) {
        if (depth == len) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 减枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;

            path.addLast(nums[i]);
            dfs(nums, len, depth + 1, path, used, list);

            path.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        Homework5 solution = new Homework5();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }


}
