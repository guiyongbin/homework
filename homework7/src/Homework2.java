/**
 * 208 实现Trie 前缀树
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

public class Homework2 {
    static class Trie{

        private MyTrieNode root;
        public Trie() {
            root = new MyTrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            MyTrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.constainsKey(currentChar)) {
                    node.put(currentChar, new MyTrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            MyTrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            MyTrieNode node = searchPrefix(prefix);
            return null != node;
        }


        private MyTrieNode searchPrefix(String word) {
            MyTrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.constainsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }


    }


    static class MyTrieNode {
        private MyTrieNode[] links;
        private final int R = 26;

        private boolean isEnd;

        public MyTrieNode() {
            links = new MyTrieNode[R];
        }

        public boolean constainsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public MyTrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, MyTrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
