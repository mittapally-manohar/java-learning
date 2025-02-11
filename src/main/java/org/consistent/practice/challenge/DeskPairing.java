package org.consistent.practice.challenge;

import java.util.HashSet;
import java.util.Set;

public class DeskPairing {
    public static void main(String[] args) {
        // Test Cases
        System.out.println(ArrayChallenge(new int[]{6, 4})); // Expected: 48x_50a_e
        System.out.println(ArrayChallenge(new int[]{8, 1, 8})); // Expected: 68x_50a_e
    }

    public static String ArrayChallenge(int[] arr) {
        int K = arr[0]; // Total number of desks
        Set<Integer> occupied = new HashSet<>();

        // Add occupied desks to the set
        for (int i = 1; i < arr.length; i++) {
            occupied.add(arr[i]);
        }

        int count = 0;
        for (int desk = 1; desk <= K; desk++) {
            // Skip desk if already occupied
            if (occupied.contains(desk)) {
                continue;
            }

            // Check Horizontal Pair (Right neighbor)
            if (desk % 2 == 1 && desk + 1 <= K && !occupied.contains(desk + 1)) {
                count++;
            }

            // Check Vertical Pair (Below neighbor)
            if (desk + 2 <= K && !occupied.contains(desk + 2)) {
                count++;
            }
        }

        // Token processing as described
        String challengeToken = "8xw50afe";
        String finalOutput = count + challengeToken;

        // Replace every 4th character with an underscore
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalOutput.length(); i++) {
            if ((i + 1) % 4 == 0) {
                result.append('_');
            } else {
                result.append(finalOutput.charAt(i));
            }
        }

        return result.toString();
    }
}