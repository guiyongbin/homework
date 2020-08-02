package com.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework6 {


    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;


    }

    private static int decades(int count) {
        int decade = 1;
        while (count > 0) {
            decade *= 10;
            count--;
        }
        return decade;
    }


    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] ints = plusOne(arr);
        print(ints);

       // System.out.println( 1000000000*9L);

    }

    private static void print(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
    }
}
