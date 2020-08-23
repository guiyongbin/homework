import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 单词接龙1
 */
public class homework1 {


    /**
     * //             /  dot  -   dog \
     * //  hit   hot                    cog
     * //             \   lot  -   log/
     * // 方法1： 比较每个单词的和其他单词不同字符的个数，如果不同字符的个数恰好是1 那么就选中这个单词
     * //         比较的次数就是N,  O(N*wordLen)
     * //
     * //  方法2： O（26*wordLen) 枚举小写字母，看看是不是在后面的 字典里
     * //
     * //
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        int step = 1;

        while (!q.isEmpty()) {
            int currentSize = q.size();

            for (int i = 0; i < currentSize; i++) {
                //依次遍历当前队列里的单词
                String word = q.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < wordLen; j++) {
                    char originChar = chars[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }

                        chars[j] = k;
                        String nextWord = String.valueOf(chars);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                q.add(nextWord);
                                //标记成已经访问
                                visited.add(nextWord);
                            }

                        }


                    }

                    chars[j] = originChar;
                }
            }
            step++;
        }


        return 0;
    }


    /**
     * 双向广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        //总的visited 数组
        Set<String> visited = new HashSet<>();
        // 分别用左边和右边的扩散的哈希表代替单向的BFS里的队列
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int len = beginWord.length();
        int step = 1;

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {

            //优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char originChar = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (originChar == c) {
                            continue;
                        }
                        chars[i] = c;
                        String nextWord = String.valueOf(chars);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                nextLevelVisited.add(nextWord);
                                visited.add(nextWord);
                            }

                        }
                    }
                    chars[i] = originChar;
                }

            }
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        homework1 h = new homework1();
        String beginWord = "hit";
        String endWord = "cog";

        String str[] = {"hot", "dot", "dog", "log", "log", "cog"};
        List<String> words = Arrays.asList(str);

        int len = h.ladderLength(beginWord, endWord, words);

        System.out.println(len);

    }
}
