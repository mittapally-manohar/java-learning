package org.consistent.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    // Method to generate combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 1, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int n, int i, int k, ArrayList<Integer> current, List<List<Integer>> res) {
        if (current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (i > n) {
            return;
        }
        backtrack(n, i+1, k, current, res);
        current.add(i);

        backtrack(n, i+1, k, current, res);
        current.remove(current.size()-1);

    }

    public static void main(String[] args) {
        Combination combination = new Combination();

        // Test cases
        int n1 = 4, k1 = 2; // Expected: [[2, 4], [3, 4], [2, 3], [1, 2], [1, 3], [1, 4]]
        int n2 = 1, k2 = 1; // Expected: [[1]]
        int n3 = 5, k3 = 3; // Expected: [[2, 3, 4], [2, 3, 5], [2, 4, 5], [3, 4, 5], [1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 3, 4], [1, 3, 5], [1, 4, 5]]
        int n4 = 3, k4 = 3; // Expected: [[1, 2, 3]]
        int n5 = 6, k5 = 2; // Expected: [[2, 4], [2, 5], [2, 6], [3, 4], [3, 5], [3, 6], [4, 5], [4, 6], [5, 6], [1, 2], [1, 3], [1, 4], [1, 5], [1, 6]]


        System.out.println("Combinations of 4 choose 2: " + combination.combine(n1, k1));
        System.out.println("Combinations of 1 choose 1: " + combination.combine(n2, k2));
        System.out.println("Combinations of 5 choose 3: " + combination.combine(n3, k3));
        System.out.println("Combinations of 3 choose 3: " + combination.combine(n4, k4));
        System.out.println("Combinations of 6 choose 2: " + combination.combine(n5, k5));
    }
}