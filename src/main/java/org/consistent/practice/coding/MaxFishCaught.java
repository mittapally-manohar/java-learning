package org.consistent.practice.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxFishCaught {
    public int catchMaximumFish(int[] fish, int[] bait) {
        int count = 0;
        Arrays.sort(fish); // Sort the fish array
        Arrays.sort(bait); // Sort the bait array

        int fishIndex = 0;
        for (int i = 0; i < bait.length; i++) {
            int baitCount = 3;
            while (fishIndex < fish.length && baitCount > 0) {
                if (fish[fishIndex] > bait[i]) {
                    count++;
                    baitCount--;
                }
                fishIndex++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxFishCaught mfc = new MaxFishCaught();

        // Test cases
        int[] fish1 = {1,2,3};
        int[] bait1 = {2,4,5};
        int[] fish2 = {1, 2, 3, 4, 5};
        int[] bait2 = {3, 3, 3};
        int[] fish3 = {10, 20, 30};
        int[] bait3 = {15, 25, 35};
        int[] fish4 = {2, 4, 6, 8};
        int[] bait4 = {1, 3, 5, 7};
        int[] fish5 = {7, 7, 7, 7};
        int[] bait5 = {7, 7, 7, 7};

        System.out.println("Test 1: " + mfc.catchMaximumFish(fish1, bait1)); // Expected: 2
        System.out.println("Test 2: " + mfc.catchMaximumFish(fish2, bait2)); // Expected: 6
        System.out.println("Test 3: " + mfc.catchMaximumFish(fish3, bait3)); // Expected: 3
        System.out.println("Test 4: " + mfc.catchMaximumFish(fish4, bait4)); // Expected: 6
        System.out.println("Test 5: " + mfc.catchMaximumFish(fish5, bait5)); // Expected: 0
    }
}
