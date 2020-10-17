package week2;

import common.XNode;


import java.util.Stack;


/**
 * 二叉树的前中后序遍历
 */
public class Solution1 {

    /**
     * 前序遍历 根  左   右
     *
     * @param root
     */
    public void preOrderTravels(XNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTravels(root.left);
        preOrderTravels(root.right);

    }


    /**
     * 中序遍历  左  根  右
     *
     * @param root
     */
    public void inOrderTravels(XNode root) {
        if (root == null) {
            return;
        }
        inOrderTravels(root.left);
        System.out.println(root.value);
        inOrderTravels(root.right);

    }


    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrderTravels(XNode root) {
        if (root == null) {
            return;
        }
        postOrderTravels(root.left);
        postOrderTravels(root.right);
        System.out.println(root.value);
    }

    //////////////////////////////////////////////////////////////////////////


    /**
     * 非递归的 前序遍历
     *
     * @param root
     */
    public void preOrderTravels1(XNode root) {
        Stack<XNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            XNode pop = stack.pop();

            System.out.println(pop.value);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }
    }


    /**
     * 非递归的中序遍历
     *
     * @param root
     */
    public void inOrderTravels1(XNode root) {
        Stack<XNode> stack = new Stack<>();
        XNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;

            } else {
                XNode pop = stack.pop();
                System.out.println(pop.value);
                cur = pop.right;

            }

        }

    }


    /**
     * 非递归的后序遍历
     *左右根
     * @param root
     */
    public void postOrderTravels2(XNode root) {
        XNode cur = root;
        XNode pre = null;

        Stack<XNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre) {
                stack.pop();
                System.out.println(cur);
                pre = cur;
                cur = null;

            } else {
                cur = cur.right;
            }


        }


    }


}
