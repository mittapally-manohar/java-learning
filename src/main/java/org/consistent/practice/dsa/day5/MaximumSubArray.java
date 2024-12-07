package org.consistent.practice.dsa.day5;

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray msa = new MaximumSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(msa.maxSubArray(nums));
    }

    private int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int num : nums) {
            maxEndingHere = Math.max(maxEndingHere + num, num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
