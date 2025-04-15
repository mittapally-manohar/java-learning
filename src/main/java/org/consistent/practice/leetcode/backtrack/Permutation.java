package org.consistent.practice.leetcode.backtrack;

import java.util.List;

public class Permutation {

    // Method to generate permutations
    public List<List<Integer>> permute(int[] nums) {
        // Your implementation here
        return null;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        // Test cases
        int[] test1 = {1, 2, 3};
        int[] test2 = {0, 1};
        int[] test3 = {1};
        int[] test4 = {1, 2, 3, 4};
        int[] test5 = {};

        System.out.println("Permutations for [1, 2, 3]: " + permutation.permute(test1));
        System.out.println("Permutations for [0, 1]: " + permutation.permute(test2));
        System.out.println("Permutations for [1]: " + permutation.permute(test3));
        System.out.println("Permutations for [1, 2, 3, 4]: " + permutation.permute(test4));
        System.out.println("Permutations for []: " + permutation.permute(test5));
    }
}