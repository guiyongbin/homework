import java.util.*;

/**
 * 前k个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopK {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(k);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count != null) {
                map.put(nums[i], ++count);
            } else {
                map.put(nums[i], 1);
            }
        }


        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            p.add(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = p.poll();
            Integer value = poll.getKey();
            result.add(value);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        TopK h = new TopK();
        List<Integer> integers = h.topKFrequent(nums, 2);
        System.out.println(integers);
    }
}
