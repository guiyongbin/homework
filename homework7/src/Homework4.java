import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class Homework4 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //先将wordlist 放到哈希表里，便于判断某个单词是否在wordList里面
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 将已经访问过的 word 添加到visited的哈希表里
        Set<String> visited = new HashSet<>();

        //分别永左边和右边扩散的哈希表代替单向BFS队列，，他们在双向BFS的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        //执行双向BFD 得出左边和右边交替扩散的步数之和
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            beginVisited = nextLevelVisited;
            step++;

        }

        return 0;
    }

    /**
     * 对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     *
     * @param word
     * @param endVisited
     * @param visited
     * @param wordSet
     * @param nextLevelVisited
     * @return
     */
    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited, Set<String> visited, Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originalChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originalChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {

                    if (endVisited.contains(nextWord)) {
                        return true;
                    }

                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originalChar;
        }

        return false;
    }
}
