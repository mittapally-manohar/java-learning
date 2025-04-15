package org.consistent.practice.assessment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Netweb {
    public static void main(String[] args) {
        /**
         * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
         * You may assume that each input would have exactly one solution, and you may not use the same element twice.
         * You can return the answer in any order.
         *
         * nums = [2,7,11,15], target = 9
         */

        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for(int num: res) {
            System.out.print(num+" ");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int requiredSum = target - nums[i];
            if (map.containsKey(requiredSum)) {
                return new int[]{map.get(requiredSum), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
