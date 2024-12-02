package org.consistent.practice.coding;

import java.util.Scanner;

public class MinimumAmountProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input total energy S
        int S = scanner.nextInt();

        // Input counts of T1, T2, T3
        int cnt1 = scanner.nextInt();
        int cnt2 = scanner.nextInt();
        int cnt3 = scanner.nextInt();

        // Input costs of T1, T2, T3
        int cost1 = scanner.nextInt();
        int cost2 = scanner.nextInt();
        int cost3 = scanner.nextInt();

        // Energies of T1, T2, T3
        int energy1 = 2, energy2 = 3, energy3 = 5;

        // Solve and print the result
        int result = solve(S, cnt1, cnt2, cnt3, cost1, cost2, cost3, energy1, energy2, energy3);
        System.out.println(result);
    }

    static int solve(int S, int cnt1, int cnt2, int cnt3, int cost1, int cost2, int cost3, int energy1, int energy2, int energy3) {
        int MAX_ENERGY = S;
        int[] dp = new int[MAX_ENERGY + 1];
        for (int i = 1; i <= MAX_ENERGY; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < cnt1; i++) {
            for (int j = MAX_ENERGY; j >= energy1; j--) {
                if (dp[j - energy1] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - energy1] + cost1);
                }
            }
        }
        for (int i = 0; i < cnt2; i++) {
            for (int j = MAX_ENERGY; j >= energy2; j--) {
                if (dp[j - energy2] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - energy2] + cost2);
                }
            }
        }
        for (int i = 0; i < cnt3; i++) {
            for (int j = MAX_ENERGY; j >= energy3; j--) {
                if (dp[j - energy3] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - energy3] + cost3);
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = S; i <= MAX_ENERGY; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
