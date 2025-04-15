package org.consistent.practice.debug;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        //provide test cases
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median of [1, 3] and [2]: " + solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median of [1, 2] and [3, 4]: " + solution.findMedianSortedArrays(nums3, nums4)); // Expected: 2.5

        int[] nums5 = {};
        int[] nums6 = {1};
        System.out.println("Median of [] and [1]: " + solution.findMedianSortedArrays(nums5, nums6)); // Expected: 1.0

        int[] nums7 = {-5, 3, 6};
        int[] nums8 = {-2, 4, 8};
        System.out.println("Median of [-5, 3, 6] and [-2, 4, 8]: " + solution.findMedianSortedArrays(nums7, nums8)); // Expected: 3.5

        int[] nums9 = {1, 1, 1};
        int[] nums10 = {1, 1, 1};
        System.out.println("Median of [1, 1, 1] and [1, 1, 1]: " + solution.findMedianSortedArrays(nums9, nums10)); // Expected: 1.0
    }
}
