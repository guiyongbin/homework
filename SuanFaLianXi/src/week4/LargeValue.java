package week4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * 515号题： 在每个树行中找最大值
 */
public class LargeValue {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> d = new ArrayDeque<>();
        d.offer(root);


        while (!d.isEmpty()) {
            int maxVal = Integer.MIN_VALUE;
            int size = d.size();
            while (size>0){
                TreeNode poll = d.poll();
                maxVal = Math.max(maxVal,poll.val);

                if(poll.left!=null){
                    d.offer(poll.left);
                }
                if(poll.right!=null){
                    d.offer(poll.right);
                }
                size--;
            }
            list.add(maxVal);
        }

        return list;
    }
}
