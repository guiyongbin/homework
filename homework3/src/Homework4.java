import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列 1
 * <p>
 * https://leetcode-cn.com/problems/permutations/
 */
public class Homework4 {

    /**
     * 手写模拟搜索的过程
     * 以1开头的排列，它们是 [1,2,3] [1,3,2]
     * 2                    [2,1,3] [2,3,1]
     * 3                    [3,1,2] [3,2,1]
     * <p>
     * 全排列的树形结构     深度优先遍历
     * []
     * [1]               [2]                  [3]
     * [1,2] [1,3]        [2,1] [2,3]         [3,1] [3,2]
     * [1,2,3] [1,3,2]   [2,1,3] [2,3,1]    [3,1,2]  [3,2,1]
     * <p>
     * 深度优先遍历：
     * 每一个结点表示了求解问题的不同阶段
     * 状态重置： 回到上一个节点的时候，需要把节点的状态重置
     * <p>
     * 树形状态的重置 就是回溯算法
     * []
     * [1]
     * [1,2]
     * [1,2,3]             回退的时候就要撤销对3 的选择，返回到1 2 这个节点
     * <p>
     * 节点表示深度优先遍历的不同阶段； 我们需要2 个变量：
     * 1（是个列表，是个栈）已经选择了哪些数 ，已经选择的数放到一个列表里
     * 2 一个布尔数组，判断当前已经有哪些数字被考虑过了used[]
     * <p>
     * 状态变量  1 递归到了第几层 depth; 2 已经选择了哪些数 path; 3判断当前已经有哪些数字被考虑过了used[]
     *
     *
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, list);

        return list;
    }

    /**
     * 复杂度由递归树的节点来决定
     * 第一层      就一个数
     * 第二层   结点个数为 :在n 个数选1 个的排列，
     * 第三层   节点个数为：在n 个数里选2个排列
     *
     *
     *
     * 非叶子节点的总是是   n!*2(1-1.2^n) < 2n!  n是数组的长度
     * 将常数2 视为1 ，每个内部节点循环n 次，故非叶子节点的时间复杂度是 O(n*n!)
     * @param nums
     * @param len
     * @param depth
     * @param path
     * @param used
     * @param list
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> list) {
        if (path.size() == len) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,list);
            // 回溯  逆操作
            path.removeLast();
            used[i] = false;
        }

    }


}
