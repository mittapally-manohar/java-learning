package org.consistent.practice.dsa.day2;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 166;

        if (searchMatrix(matrix, target)) {
            System.out.println("Target found in the matrix!");
        } else {
            System.out.println("Target not found in the matrix.");
        }
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int low = 0, high = row * column - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midEle = matrix[mid/column][mid%column];
            if(midEle == target){
                return true;
            }else if(midEle > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
