package org.consistent.practice.assessment.peopletech;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] != val) {
                    nums[i++] = nums[j--];
                } else if (nums[j] == val) {
                    j--;
                }
            }
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println("Resulting Length: " + solution.removeElement(nums1, val1));
        System.out.println("Modified Array: " + java.util.Arrays.toString(nums1));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println("Resulting Length: " + solution.removeElement(nums2, val2));
        System.out.println("Modified Array: " + java.util.Arrays.toString(nums2));

        int[] nums3 = {1, 1, 1, 1};
        int val3 = 1;
        System.out.println("Resulting Length: " + solution.removeElement(nums3, val3));
        System.out.println("Modified Array: " + java.util.Arrays.toString(nums3));

        int[] nums4 = {};
        int val4 = 0;
        System.out.println("Resulting Length: " + solution.removeElement(nums4, val4));
        System.out.println("Modified Array: " + java.util.Arrays.toString(nums4));
    }
}