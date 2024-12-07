package org.consistent.practice.dsa.day4;

class IslandPerimeter {

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();

        // Example grid with an island
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        // Call the islandPerimeter method and print the result
        int perimeter = ip.islandPerimeter(grid);
        System.out.println("Island Perimeter: " + perimeter);
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.println("boom " + i + " " + j);
                    return getPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int getPerimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            System.out.println("first cond i: " + i + " j: " + j + " value: " + 1);
            return 1;
        }
        if (grid[i][j] == 0) {
            System.out.println("second cond i: " + i + " j: " + j + " value: " + 1);
            return 1;
        }
        if (grid[i][j] == -1) {
            System.out.println("third cond i: " + i + " j: " + j + " value: " + 0);
            return 0;
        }
        int count = 0;
        grid[i][j] = -1;

        count += getPerimeter(grid, i, j + 1);
        count += getPerimeter(grid, i - 1, j);
        count += getPerimeter(grid, i + 1, j);
        count += getPerimeter(grid, i, j - 1);

        return count;
    }
}