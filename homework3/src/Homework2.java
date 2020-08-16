import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Homework2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end, HashMap<Integer, Integer> map) {
        if (pre_start > pre_end) {
            return null;
        }

        int root_val = preorder[pre_start];

        Integer rootVal_index_inorder = map.get(root_val);

        int leftTreeNum = rootVal_index_inorder - in_start; // 在inorder中左边子树的数量

        //建立一个根
        TreeNode root = new TreeNode(root_val);

        root.left = buildTree(preorder, pre_start+1, pre_start + leftTreeNum, inorder, in_start, rootVal_index_inorder - 1, map);
        root.right = buildTree(preorder, pre_start + leftTreeNum + 1, pre_end, inorder, rootVal_index_inorder + 1, in_end, map);


        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
    }
}
