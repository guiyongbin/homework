/**
 * 遍历二叉树
 */
public class homework4 {

    private static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }


    public void printNode(Node node) {
        System.out.println(node.value.toString() + "--->");
    }


    /**
     * 前序遍历 根左右
     *
     * @param root
     */
    public void preOrderTraversel(Node root) {
        if (root != null) {
            printNode(root);
            preOrderTraversel(root.left);
            preOrderTraversel(root.right);
        }
    }


    /**
     * 中序 左 根 右
     *
     * @param root
     */
    public void inOrderTraversel(Node root) {
        if (root != null) {
            inOrderTraversel(root.left);
            printNode(root);
            inOrderTraversel(root.right);
        }
    }


    /**
     * 后序遍历   左右 根
     *
     * @param root
     */
    public void postOrderTraversel(Node root) {
        if (root != null) {
            postOrderTraversel(root.left);
            postOrderTraversel(root.right);
            printNode(root);
        }
    }




}
