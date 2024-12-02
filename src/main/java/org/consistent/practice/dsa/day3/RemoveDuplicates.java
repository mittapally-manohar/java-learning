package org.consistent.practice.dsa.day3;

public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast< nums.length; fast++){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
