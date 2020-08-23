/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class homework2 {


    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            // 这里这么写是照顾到 后半个数组的 mid 的索引
            int mid = start + (end - start) / 2;

            int val = nums[mid];
            if (val == target) {
                return mid;
            }
            // 左边的值小于 中间的值  左半边有序
            if (nums[mid] >= nums[start]) {
                //内部使用 二分搜索
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }


            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }
}
