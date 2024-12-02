package org.consistent.practice.coding;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Number of test cases
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] inp = br.readLine().split(" ");
            int N = Integer.parseInt(inp[0]);
            int K = Integer.parseInt(inp[1]);
            int[] A = new int[N];
            String[] inpA = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(inpA[i]);
            }
            result.append(solve(N, K, A)).append("\n");
        }

        System.out.print(result.toString());
    }

    static long solve(int N, int K, int[] A) {
        long count = 0;
        int left = 0;
        long currentCount = 0;

        for (int right = 0; right < N; right++) {
            if (A[right] == K) {
                currentCount = right - left + 1;
            } else if (A[right] > K) {
                left = right + 1;
                currentCount = 0;
            }
            count += currentCount;
        }

        return count;
    }
}
