import java.util.ArrayList;
import java.util.List;

/**
 * 590 N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 * <p>
 * 589 N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * <p>
 * <p>
 * 429 N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class N_Arry_Tree {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    private List<Integer> list = new ArrayList<>();

    /**
     * 前序
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            List<Node> children = root.children;
            for (Node child : children) {
                postorder(child);
            }
        }
        return list;
    }

    /**
     * 后序
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root != null) {
            List<Node> children = root.children;
            for (Node child : children) {
                postorder(child);
            }
            list.add(root.val);
        }
        return list;
    }

///////////////////////////////////////////////////////////////////////////

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 时间复杂度：O(n)。nn 指的是节点的数量
     * 空间复杂度：正常情况 O(\log n)O(logn)，最坏情况 O(n)O(n)。运行时在堆栈上的空间
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (result != null) {
            levelHelper(root, 0);
        }
        return result;
    }

    public void levelHelper(Node root, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for (Node child : root.children) {
            levelHelper(child,level+1);
        }
    }


}
