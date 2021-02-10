import java.util.ArrayList;
import java.util.List;

/**
 * 94
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * 144
 * 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTree {


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


    List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public List<Integer> inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
//            System.out.println(treeNode.value.toString());
            list.add(treeNode.val);
            inOrder(treeNode.right);
        }
        return list;
    }
//////////////////////////////////////////////////////////////////////

    /**
     * 前序遍历
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
//            System.out.println(treeNode.val);
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public List<Integer> postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
//            System.out.println(treeNode.val);
            list.add(root.val);
        }
        return list;
    }
}
