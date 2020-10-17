package week4;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 * <p>
 * 单词接龙2
 */
public class FindLadders {


    //BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> solutions = new ArrayList<>();

        Set<String> disSet = new HashSet<>(wordList);
        if (!disSet.contains(endWord)) {
            return solutions;
        }
        //已经访问过的单词集合，只找寻最短路径，，所以之前出现过的单词不用出现在下一层
        Set<String> visited = new HashSet<>();
        //积累每一层的结果队列
        Queue<List<String>> queen = new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queen.add(list);
        visited.add(beginWord);
        //是否到达符合条件的层：如果该层添加某一单词符合目标单词，那么说明截至该层的所有解为最短路径
        boolean flag = false;
        while (!queen.isEmpty() && !flag) {
            int size = queen.size();

            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queen.poll();
                //获取该路径上一层的单词
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String(chars);

                        if (disSet.contains(str) && !visited.contains(str)) {
                            //生成新的路径
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            //如果该单词是目标单词，将该路径添加到结果中，查询到此为止
                            if (str.equals(endWord)) {
                                flag = true;
                                solutions.add(pathList);
                            }

                            queen.add(pathList);

                            subVisited.add(str);

                        }

                    }
                    chars[j] = temp;
                }
            }

            visited.addAll(subVisited);
        }


        return solutions;
    }
}
