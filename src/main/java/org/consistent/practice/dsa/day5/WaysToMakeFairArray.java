package org.consistent.practice.dsa.day5;

public class WaysToMakeFairArray {
    public static void main(String[] args) {
        WaysToMakeFairArray wtmfa = new WaysToMakeFairArray();
        int[] nums = new int[]{1,1,1};
        System.out.println(wtmfa.waysToMakeFair(nums));
    }

    private int waysToMakeFair(int[] nums) {
        int n = nums.length, evenSum = 0, oddSum = 0;
        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 ==0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
            evenPrefix[i] = evenSum;
            oddPrefix[i] = oddSum;
        }
        int count = 0, evenNewSum = 0, oddNewSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenNewSum = evenPrefix[i] - nums[i] + oddSum - oddPrefix[i];
                oddNewSum = oddPrefix[i] + evenSum - evenPrefix[i];
            } else {
                evenNewSum = evenPrefix[i] + oddSum - oddPrefix[i];
                oddNewSum = oddPrefix[i] - nums[i] + evenSum - evenPrefix[i];
            }
            if (evenNewSum == oddNewSum){
                count ++;
            }
        }
        return count;
    }
}
