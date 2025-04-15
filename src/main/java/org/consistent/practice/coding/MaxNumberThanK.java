package org.consistent.practice.coding;

import java.util.ArrayList;
import java.util.List;

public class MaxNumberThanK {
    /**
     * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
     *
     * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
     *
     * 10 = max(10, 5, 2)
     * 7 = max(5, 2, 7)
     * 8 = max(2, 7, 8)
     * 8 = max(7, 8, 7)
     * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 8, 7};
        int k = 3;
        List<Integer> res = new ArrayList<>();
        int count = 1;
        List<Integer> maxNumber = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            maxNumber.add(nums[i]);
            if (count == k) {
                res.add(maxNumber.stream()
                        .max(Integer::compare)
                        .get());
                maxNumber.remove(0);
                count--;
            }
            count++;
        }
        System.out.println(res);
    }
}
