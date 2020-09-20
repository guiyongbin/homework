import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class homework3 {

    /**
     * 使用java 系统提供的 LinkedHashMap 实现LRU 缓存
     */
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;


        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


    /**
     * 双向链表来实现LRUCache
     */
    static class LRUCache1 {
        static class DLInkedNode {
            int key;
            int value;
            DLInkedNode prev;
            DLInkedNode next;

            public DLInkedNode() {
            }

            public DLInkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLInkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLInkedNode head, tail;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLInkedNode();
            tail = new DLInkedNode();
            head.next = tail;
            tail.prev = head;

        }


        public int get(int key) {
            DLInkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }


        public void put(int key, int value) {
            DLInkedNode node = cache.get(key);
            if (node == null) {
                DLInkedNode newNode = new DLInkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    DLInkedNode tail = remoeTail();
                    cache.remove(tail.key);
                    --size;

                }

            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLInkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLInkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLInkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLInkedNode remoeTail() {
            DLInkedNode prev = tail.prev;
            removeNode(prev);
            return prev;
        }

    }

}
