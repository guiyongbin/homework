package com.homework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeNum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> listList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return listList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || (nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {

                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        listList.add(list);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return listList;
    }

}
