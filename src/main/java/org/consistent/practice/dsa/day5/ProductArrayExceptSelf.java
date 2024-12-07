package org.consistent.practice.dsa.day5;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        ProductArrayExceptSelf paes = new ProductArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = paes.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }

    private int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
}
