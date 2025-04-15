package org.consistent.practice.coding;

import java.util.HashSet;
import java.util.Set;

public class UniqueTripletCount {
    public int getUniqueTripletCount(String s) {
        Set<Character> seen = new HashSet<>();
        int target = 3;
        int count = 0;
        for (int i = 0; i <= s.length() - target; i++) {
            seen.clear();
            int k = i;
            for(int j = 0 ; j < target; j++) {
                seen.add(s.charAt(k++));
            }
            if(seen.size() == target) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        UniqueTripletCount utc = new UniqueTripletCount();

        // Test cases
        String test1 = "abcabcabc";
        String test2 = "aaabbbccc";
        String test3 = "abcdef";
        String test4 = "aabbcc";
        String test5 = "abc";

        System.out.println("Test 1: " + utc.getUniqueTripletCount(test1)); // Expected: 7
        System.out.println("Test 2: " + utc.getUniqueTripletCount(test2)); // Expected: 0
        System.out.println("Test 3: " + utc.getUniqueTripletCount(test3)); // Expected: 4
        System.out.println("Test 4: " + utc.getUniqueTripletCount(test4)); // Expected: 0
        System.out.println("Test 5: " + utc.getUniqueTripletCount(test5)); // Expected: 1
    }

}
