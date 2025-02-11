package org.consistent.practice.challenge;

import java.util.Scanner;

public class Solution {
    public static void solveGame(int rows, int cols, int[][] points) {
        int totalPoints = 0;
        int row = 0, col = 0;

        // Add points at the starting position
        totalPoints += points[row][col];

        // Traverse down to the last row
        while (row < rows - 1) {
            row++;
            totalPoints += points[row][col];
        }

        // Traverse right to the last column
        while (col < cols - 1) {
            col++;
            totalPoints += points[row][col];
        }

        // Print the total points collected
        System.out.println(totalPoints);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read grid dimensions
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Read grid points
        int[][] points = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                points[i][j] = scanner.nextInt();
            }
        }

        // Solve the game
        solveGame(rows, cols, points);
    }
}
