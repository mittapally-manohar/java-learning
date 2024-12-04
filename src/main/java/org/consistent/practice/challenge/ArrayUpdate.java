package org.consistent.practice.challenge;

public class ArrayUpdate {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 9, 9, 9, 9};
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<9){
                nums[i]++;
                printArray(nums);
                return;
            }
            nums[i]=0;
        }
        int[] res = new int[n+1];
        res[0]=1;
        printArray(res);
    }

    public static void printArray(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
