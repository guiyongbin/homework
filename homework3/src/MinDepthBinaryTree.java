/**
 * 111号
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 */
public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int level = Integer.MAX_VALUE;

        if (root.left != null) {
            level = Math.min(minDepth(root.left), level);
        }

        if (root.right != null) {
            level = Math.min(minDepth(root.right), level);
        }
        return level + 1;
    }
}
