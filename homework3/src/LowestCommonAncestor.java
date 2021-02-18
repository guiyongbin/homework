
/**
 *
 * 236
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 二叉树的公共祖先
 */

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return left;
        }

        if (right == null) {
            return right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_1 = new TreeNode(1);
        root.left = node_5;
        root.right = node_1;

        TreeNode node_2 = new TreeNode(2);
        TreeNode node_6 = new TreeNode(6);

        node_5.left = node_6;
        node_5.right = node_2;

        TreeNode node_0 = new TreeNode(0);
        TreeNode node_8 = new TreeNode(8);

        node_1.left = node_0;
        node_1.right = node_8;

        TreeNode node_7 = new TreeNode(7);
        TreeNode node_4 = new TreeNode(4);
        node_2.left = node_7;
        node_2.right = node_4;

        LowestCommonAncestor d = new LowestCommonAncestor();
        TreeNode commonNode = d.lowestCommonAncestor(root, node_8, node_0);
        System.out.println(commonNode.val);

    }
}
