package org.consistent.practice.challenge;

import java.util.*;

public class MaxSubsetValue {

        public static int get_ans(int N, List<List<Integer>> list) {
            int maxValue = 0;

            // Iterate through all possible square sub-grids
            for (int size = 1; size <= N; size++) { // Size of the square grid
                for (int i = 0; i <= N - size; i++) { // Starting row
                    for (int j = 0; j <= N - size; j++) { // Starting column
                        // Use a set to store distinct elements in the current square sub-grid
                        Set<Integer> distinctElements = new HashSet<>();
                        for (int x = i; x < i + size; x++) {
                            for (int y = j; y < j + size; y++) {
                                distinctElements.add(list.get(x).get(y));
                            }
                        }

                        // Calculate the value of the sub-grid and update the maximum value
                        int subGridValue = distinctElements.size();
                        maxValue = Math.max(maxValue, subGridValue);
                    }
                }
            }

            return maxValue;
        }

    public static void main(String[] args) {
        // Define the grid
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1)
        );

        // Define the size of the sub-grid
        int N = 1;

        // Call the method and print the result
        int result = get_ans(N, grid);
        System.out.println("Maximum number of distinct elements in any sub-grid: " + result);
    }
}
