/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98 验证二叉搜索树
 */
public class ValidBinarySearchTree {


    private static class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return preOrder(root, null, null);
    }

    private boolean preOrder(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        Integer cur = root.val;

        if (lower != null && cur <= lower) {
            return false;
        }
        if (upper != null && cur >= upper) {
            return false;
        }

        if (!preOrder(root.left, lower, cur)) {
            return false;
        }
        if (!preOrder(root.right, cur, upper)) {
            return false;
        }
        return true;
    }


}
