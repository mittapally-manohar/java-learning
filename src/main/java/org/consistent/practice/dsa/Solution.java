package org.consistent.practice.dsa;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    public void backtrack(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(convertArrayToList(nums)));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, index + 1, res);
            swap(nums, index, i); // Backtrack (undo swap)
        }
    }

    private List<Integer> convertArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.println("Permutations of {1, 2, 3}: " + solution.permute(nums1));

        int[] nums2 = {0, 1};
        System.out.println("Permutations of {0, 1}: " + solution.permute(nums2));

        int[] nums3 = {1};
        System.out.println("Permutations of {1}: " + solution.permute(nums3));
    }
}