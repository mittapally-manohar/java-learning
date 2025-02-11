package org.consistent.practice.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubarrayLength {

    public static int solution(int[] latencies, int threshold) {
        // Deques to store indices of maximum and minimum values
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0, maxLength = 0;

        // Iterate through the array
        for (int right = 0; right < latencies.length; right++) {
            // Maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && latencies[maxDeque.peekLast()] <= latencies[right]) {
                maxDeque.pollLast();
            }

            // Maintain increasing order in minDeque
            while (!minDeque.isEmpty() && latencies[minDeque.peekLast()] >= latencies[right]) {
                minDeque.pollLast();
            }

            // Add current element to both deques
            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            // Check if the current window is valid
            while (latencies[maxDeque.peekFirst()] - latencies[minDeque.peekFirst()] > threshold) {
                // Shrink the window from the left
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            // Update the maximum length of the subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test the solution
        int[] latencies = {1, 3, 6, 2, 8, 4, 10};
        int threshold = 4;

        System.out.println("Maximum subarray length: " + solution(latencies, threshold));
    }
}
