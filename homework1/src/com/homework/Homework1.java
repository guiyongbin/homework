package com.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除排序数组中的重复项
 */
public class Homework1 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int sum = nums.length;

        int count = 1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                sum = sum - count+1;
//                count = 1;
            }

        }


        return sum;
    }

    public static void main(String[] args) {
        //   int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = {1, 1, 1};
        int i = removeDuplicates(arr);
        System.out.println(i);
//
    }
}
