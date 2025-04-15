package org.consistent.practice.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n];
        int[] temp = nums.clone();
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(temp[i])){
                map.put(temp[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));
    }
}