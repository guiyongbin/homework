package week2;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 22  括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 */
public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateHelper(list, n, 0, 0, "");
        return list;
    }

    private void generateHelper(List<String> list, int max, int left, int right, String val) {
        if (left == max && right == max) {
            list.add(val);
            return;
        }
        if (left < max) {
            generateHelper(list, max, left + 1, right, val + "(");
        }
        if (left > right) {
            generateHelper(list, max, left, right + 1, val + ")");
        }

    }


    private static class Node {
        public String val;
        public int left;
        public int right;

        public Node(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        Node node = new Node("", 0, 0);
        Deque<Node> d = new ArrayDeque<>();
        d.offer(node);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size > 0) {
                Node poll = d.poll();
                if (poll.left == n && poll.right == n) {
                    list.add(poll.val);
                }

                if (poll.left < n) {
                    Node left = new Node(poll.val + "(", poll.left + 1, poll.right);
                    d.offer(left);

                }
                if (poll.left > poll.right) {
                    Node right = new Node(poll.val + ")", poll.left, poll.right + 1);
                    d.offer(right);
                }

                size--;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();

        List<String> list = g.generateParenthesis(3);
        System.out.println(list);
    }


}
