package org.consistent.practice.dsa.day2;

public class SearchRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                high = high - 1;
                low = low + 1;
                continue;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
