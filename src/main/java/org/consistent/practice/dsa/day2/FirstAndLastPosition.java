package org.consistent.practice.dsa.day2;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        FirstAndLastPosition finder = new FirstAndLastPosition();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = finder.searchRange(nums, target);

        System.out.println("First and Last Position of " + target + ": " + Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = findTarget(nums, target, true);
        int r = findTarget(nums, target, false);
        return new int[]{l, r};
    }

    public static int findTarget(int[] nums, int target, boolean isLeft) {
        int low = 0, high = nums.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                pos = mid;
                if (isLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }
}
