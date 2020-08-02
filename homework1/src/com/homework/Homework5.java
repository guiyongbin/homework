package com.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两数之和
 */
public class Homework5 {


    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int shortvalue = target-nums[i];
           if(map.containsKey(shortvalue)&&map.get(shortvalue)!=i){
               return new int[] { i, map.get(shortvalue) };
           }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
         int[] arr = {2, 7, 11, 15};
      //  int[] arr = {3, 2, 4};
        int[] ints = twoSum(arr, 9);

        print(ints);

    }


    private static void print(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
    }
}
