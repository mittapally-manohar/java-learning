package org.consistent.practice.dsa.day2.one;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = findElement(0,nums.length-1,nums,target,true);
        int r = findElement(0,nums.length-1,nums,target,false);
        return new int[]{l,r};
    }

    public int findElement(int low, int high, int[] nums, int target, boolean isLeft){
        int pos = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                pos = mid;
                if(isLeft){
                    high=mid-1;
                }else{
                    low =mid+1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
//        int[] nums1 = {5, 7, 7, 8, 8, 10};
//        int target1 = 8;
//        printResult(solution.searchRange(nums1, target1)); // Expected output: [3, 4]
//
//        int[] nums2 = {5, 7, 7, 8, 8, 10};
//        int target2 = 6;
//        printResult(solution.searchRange(nums2, target2)); // Expected output: [-1, -1]
//
        int[] nums3 = {1, 1, 1, 1};
        int target3 = 1;
        printResult(solution.searchRange(nums3, target3)); // Expected output: [0, 3]
//
//        int[] nums4 = {};
//        int target4 = 0;
//        printResult(solution.searchRange(nums4, target4)); // Expected output: [-1, -1]

        int[] nums5 = {1};
        int target5 = 1;
        printResult(solution.searchRange(nums5, target5)); // Expected output: [0, 0]
    }

    // Helper method to print the results
    private static void printResult(int[] result) {
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}