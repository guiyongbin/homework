package com.homework;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * 旋转数组
 */
public class HomeWork2 {

    public static void rotate(int[] nums, int k) {
        int len = nums.length;// 7-1 =6

        while (k > 0) {
            int i = 0;
            int temp = nums[len - 1];
            while (len - i - 1 > 0) {
                nums[len - 1 - i] = nums[len - 2 - i];
                i++;
            }
            nums[0] = temp;
            k--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);

        print(arr);
    }


    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
