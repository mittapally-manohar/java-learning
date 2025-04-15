package org.consistent.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    // Method to generate subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int[] nums, int i, ArrayList<Integer> current, List<List<Integer>> res) {
        if (nums.length == i) {
            res.add(new ArrayList<>(current));
            return;
        }
        backtrack(nums, i+1, current, res);
        current.add(nums[i]);
        backtrack(nums, i+1, current, res);
        current.remove(current.size()-1);
    }

    public static void main(String[] args) {
        Subset subset = new Subset();

        // Test cases
        int[] test1 = {1, 2, 3}; // Expected: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
        int[] test2 = {0}; // Expected: [[], [0]]
        int[] test3 = {1, 2, 2}; // Expected: [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
        int[] test4 = {4, 5, 6, 7}; // Expected: [[], [4], [5], [6], [7], [4, 5], [4, 6], [4, 7], [5, 6], [5, 7], [6, 7], [4, 5, 6], [4, 5, 7], [4, 6, 7], [5, 6, 7], [4, 5, 6, 7]]
        int[] test5 = {}; // Expected: [[]]

        System.out.println("Subsets for [1, 2, 3]: " + subset.subsets(test1));
        System.out.println("Subsets for [0]: " + subset.subsets(test2));
        System.out.println("Subsets for [1, 2, 2]: " + subset.subsets(test3));
        System.out.println("Subsets for [4, 5, 6, 7]: " + subset.subsets(test4));
        System.out.println("Subsets for []: " + subset.subsets(test5));
    }
}