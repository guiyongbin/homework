import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的前序遍历
 */
public class homework3 {

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

    public List<Integer> preorder(Node root) {
        List<Integer> integers = new ArrayList<>();
        preorder(root, integers);
        return integers;
    }

    public void preorder(Node root, List<Integer> integers) {
        if (root != null) {
            integers.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    preorder(child, integers);
                }
            }
        }

    }

}
