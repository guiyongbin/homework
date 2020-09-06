import java.util.Arrays;

/**
 * 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 */

public class homework4 {


    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) {
                    break;
                }
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }

        return time;
    }

    public static void main(String[] args) {
        homework4 h = new homework4();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int i = h.leastInterval(tasks, n);
        System.out.println("任务调度器：" + i);
    }
}
