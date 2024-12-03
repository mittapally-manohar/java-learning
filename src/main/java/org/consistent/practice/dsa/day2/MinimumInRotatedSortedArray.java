package org.consistent.practice.dsa.day2;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1}; // Example of a rotated sorted array
        MinimumInRotatedSortedArray finder = new MinimumInRotatedSortedArray(); // Assuming your class name is FirstAndLastPosition

        int minElement = finder.findMin(nums);

        System.out.println("The minimum element is: " + minElement);
    }


    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
