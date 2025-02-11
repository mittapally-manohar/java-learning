package org.consistent.practice.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayChallenge {
    public static String ArrayChallenge(String[] strArr) {
        // Parse the first array
        String[] array1 = strArr[0].replaceAll("[\\[\\] ]", "").split(",");
        // Parse the second array
        String[] array2 = strArr[1].replaceAll("[\\[\\] ]", "").split(",");

        // Convert to integer lists
        List<Integer> list1 = new ArrayList<>();
        for (String s : array1) {
            if (!s.isEmpty()) list1.add(Integer.parseInt(s));
        }

        List<Integer> list2 = new ArrayList<>();
        for (String s : array2) {
            if (!s.isEmpty()) list2.add(Integer.parseInt(s));
        }

        // Result list to store the summed elements
        List<Integer> result = new ArrayList<>();

        // Add corresponding elements from both arrays
        int minLength = Math.min(list1.size(), list2.size());
        for (int i = 0; i < minLength; i++) {
            result.add(list1.get(i) + list2.get(i));
        }

        // Append remaining elements from the longer array
        if (list1.size() > minLength) {
            result.addAll(list1.subList(minLength, list1.size()));
        } else if (list2.size() > minLength) {
            result.addAll(list2.subList(minLength, list2.size()));
        }

        // Convert result list to a hyphen-separated string
        return result.toString().replaceAll("[\\[\\] ]", "").replace(",", "-");
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(ArrayChallenge(new String[]{"[5,2,3]", "[2,2,3,10,6]"})); // Output: 6-4-13-17
        System.out.println(ArrayChallenge(new String[]{"[1, 2, 3]", "[2, 2, 3, 10, 6]"})); // Output: 3-4-6-10-6
        System.out.println(ArrayChallenge(new String[]{"[1, 2, 1]", "[2, 1, 5, 2]"})); // Output: 3-3-6-2
    }
}