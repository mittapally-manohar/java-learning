package org.consistent.practice.dsa.day3;

public class HouseRobber {
    public int rob(int[] nums) {
        int oldState = 0;
        int newState = 0;
        for (int i = 0; i < nums.length; i++) {
            int curState = Math.max(oldState + nums[i], newState);
            oldState = newState;
            newState = curState;
        }
        return newState;
    }
}
