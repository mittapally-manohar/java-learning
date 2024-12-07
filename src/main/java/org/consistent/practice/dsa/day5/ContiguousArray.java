package org.consistent.practice.dsa.day5;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        int[] nums = new int[]{0, 1, 0, 1, 0, 0, 1, 1};
        System.out.println(ca.findMaxLength(nums));
    }

    private int findMaxLength(int[] nums) {
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
