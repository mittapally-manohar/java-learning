package org.consistent.practice.assessment;

class Solution {
    public int longestMountain(int[] arr) {
        int maxLength = 0;
        if (arr.length < 2) {
            return maxLength;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1, right = i + 1;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;

                }
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        int result = solution.longestMountain(arr);
        System.out.println("Longest Mountain Length: " + result);
    }
}