package com.homework;

public class Homework7 {


    public static int trap(int[] height) {
        int maxArea = 0;
        if (height.length <= 2) {
            return maxArea;
        }


        for (int i = 0; i < height.length; i++) {

            int currentHeight = height[i];
            if (currentHeight == 0) {
                continue;
            }
            int p = i;


            int fakeArea = 0;
            int rightHeight = 0;
            int area = 0;
            for (int j = i+1; j < height.length; j++) {
                fakeArea = fakeArea + height[j];
                rightHeight = height[j];

                int width = j - p - 1;
                area = Math.min(currentHeight, rightHeight) * width - fakeArea;

            }

            maxArea = maxArea + area;
        }

        return maxArea;
    }


    public static void main(String[] args) {
        //     int[] nums1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums1 = {0, 1, 0, 2};
        //  int[] nums1 = {2, 1, 0, 1, 3};
        int trap = trap(nums1);
        System.out.println(trap);

    }
}



