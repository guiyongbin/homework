package com.homework;


/**
 * 146
 * 盛更多水的容器
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainMostWater {


    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int maxArea = 0;

        while (leftIndex < rightIndex) {

            int leftValue = height[leftIndex];
            int rightValue = height[rightIndex];

            int wateLevel = Math.min(leftValue, rightValue);

            int waterWidth = rightIndex - leftIndex;

            maxArea = Math.max(maxArea, wateLevel * waterWidth);

            if (leftValue < rightValue) {
                while (leftIndex < rightIndex && leftValue >=height[leftIndex]) {
                    leftIndex++;
                }

            } else {
                while (leftIndex < rightIndex && rightValue >= height[rightIndex]) {
                   rightIndex--;
                }
            }
        }
        return maxArea;
    }

}
