package org.consistent.practice.challenge;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray merger = new MergeSortedArray();

        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;

        merger.merge(nums1, m, nums2, n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = 0; i < nums1.length && j < nums2.length; i++){
            if (nums1[i] > nums2[j]){
                int t = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = t;
            } else if (nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
