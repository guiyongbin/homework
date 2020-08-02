package com.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class HomeworkDeque {

    private static class Node<T> {
        public T e;
        public Node prev;
        public Node next;

        public Node(T e, Node prev, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }
    }


    private interface XDeque<T> {
        void addFirst(T t);

        void addLast(T t);

        T peek();

        T poll();
    }

    private static class MyDeque<T> implements XDeque<T> {

        private Node<T> rootNode = null;

        private Node<T> firstNode = null;
        private Node<T> endNode = null;


        public MyDeque() {

            firstNode = null;
            endNode = null;

        }

        @Override
        public void addFirst(T t) {
            Node node = new Node(t, null, firstNode);
            //如果第一个元素为空，那么添加的元素 赋值给 firstNode 和 lastNode
            if (firstNode == null) {
                firstNode = node;
                endNode = node;
            } else {
                //如果前一个元素不为空，那么前一个元素的prev 赋值成 node,
                firstNode.prev = node;
                //firstNode 变成新添加的这个元素
                firstNode = node;
            }
        }

        @Override
        public void addLast(T t) {
            Node node = new Node(t, endNode, null);
            if (endNode == null) {
                endNode = node;
                firstNode = node;
            } else {
                endNode.next = node;
                endNode = node;
            }

        }

        @Override
        public T peek() {
            return firstNode.e;
        }

        @Override
        public T poll() {
            T target = null;
            target = firstNode.e;
            firstNode = firstNode.next;

            return target;
        }
    }


    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();
//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.addFirst(3);

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);



//        while (deque.pop() != null) {
//            System.out.println(deque.peek());
//        }


        //   testJavaDeque();

    }

    private static void testJavaDeque() {

        Deque<Integer> d = new ArrayDeque<>();
//        d.addFirst(1);
//        d.addFirst(2);
//        d.addFirst(3);

        d.addLast(1);
        d.addLast(2);
        d.addLast(3);

        while (d.pop() != null) {
            System.out.println(d.peek());
        }
    }


}
