package com.homework;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 合并2个有序数组
 */
public class Homework4 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {

            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }

        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    private static void moveArr(int[] arr, int fromIndex) {
        int i = 0;
        while (arr.length - 1 - i > fromIndex) {

            arr[arr.length - 1 - i] = arr[arr.length - 2 - i];
            i++;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};

        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);

        print(nums1);
    }


    private static void print(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
    }
}
