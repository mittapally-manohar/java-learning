package org.consistent.practice.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++){
            if (i!=0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = n-1;
            //-4 -1 -1 0 1 2
            while (j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }else if (sum > 0) {
                    while (j < --k && nums[k+1]==nums[k]){
                    }
                }else {
                    while (++j < k && nums[j]==nums[j-1]){
                      
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1: " + solution.threeSum(nums1));

        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Test Case 2: " + solution.threeSum(nums2));

        int[] nums3 = {-2, 0, 1, 1, 2};
        System.out.println("Test Case 3: " + solution.threeSum(nums3));

        int[] nums4 = {};
        System.out.println("Test Case 4: " + solution.threeSum(nums4));

        int[] nums5 = {0};
        System.out.println("Test Case 5: " + solution.threeSum(nums5));
    }
}