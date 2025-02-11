package org.consistent.practice.challenge;

import java.util.HashSet;
import java.util.Scanner;

public class MissingElementFinder {
    public static int findMissingElement(int N, int[] A, int[] B) {
        HashSet<Integer> setB = new HashSet<>();
        for (int num : B) {
            setB.add(num);
        }
        int minMissing = Integer.MAX_VALUE;
        for (int num : A) {
            if (!setB.contains(num)) {
                minMissing = Math.min(minMissing, num);
            }
        }
        return (minMissing == Integer.MAX_VALUE) ? -1 : minMissing;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        System.out.println(findMissingElement(N, A, B));
        scanner.close();
    }
}
