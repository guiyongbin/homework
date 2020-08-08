import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/
 */


public class Homework5 {

    static class Node {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }

        levelOrder(root, 0, list);

        return list;
    }

    private void levelOrder(Node node, int level, List<List<Integer>> list) {
        if (list.size() <= level) {
            ArrayList<Integer> integers = new ArrayList<>();
            list.add(integers);
        }
        list.get(level).add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                levelOrder(child, level + 1, list);
            }
        }
    }

}
