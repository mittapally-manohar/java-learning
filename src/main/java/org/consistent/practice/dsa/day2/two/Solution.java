package org.consistent.practice.dsa.day2.two;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0, j=n-1;
        while(i<m && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Target is present in the matrix
        int[][] matrix1 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target1 = 5;
        System.out.println(solution.searchMatrix(matrix1, target1)); // Expected: true

        // Test case 2: Target is absent in the matrix
        int[][] matrix2 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target2 = 15;
        System.out.println(solution.searchMatrix(matrix2, target2)); // Expected: false

        // Test case 3: Empty matrix
        int[][] matrix3 = {};
        int target3 = 10;
        System.out.println(solution.searchMatrix(matrix3, target3)); // Expected: false

        // Test case 4: Single row, target is present
        int[][] matrix4 = {{1, 3, 5, 7, 9}};
        int target4 = 7;
        System.out.println(solution.searchMatrix(matrix4, target4)); // Expected: true

        // Test case 5: Single row, target is absent
        int[][] matrix5 = {{1, 3, 5, 7, 9}};
        int target5 = 6;
        System.out.println(solution.searchMatrix(matrix5, target5)); // Expected: false

        // Test case 6: Single column, target is present
        int[][] matrix6 = {
                {1},
                {3},
                {5},
                {7}
        };
        int target6 = 3;
        System.out.println(solution.searchMatrix(matrix6, target6)); // Expected: true

        // Test case 7: Single column, target is absent
        int[][] matrix7 = {
                {1},
                {3},
                {5},
                {7}
        };
        int target7 = 6;
        System.out.println(solution.searchMatrix(matrix7, target7)); // Expected: false

        // Test case 8: Large matrix, target is the smallest number
        int[][] matrix8 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target8 = 1;
        System.out.println(solution.searchMatrix(matrix8, target8)); // Expected: true

        // Test case 9: Large matrix, target is the largest number
        int[][] matrix9 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target9 = 9;
        System.out.println(solution.searchMatrix(matrix9, target9)); // Expected: true
    }
}