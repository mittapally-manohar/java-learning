package org.consistent.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    // Method to generate letter case permutations
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }

    private void backtrack(char[] charArray, int i, List<String> res) {
        if (i == charArray.length) {
            res.add(new String(charArray));
            return;
        }
        if(Character.isDigit(charArray[i])){
            backtrack(charArray, i+1, res);
        } else{
            charArray[i] = Character.toLowerCase(charArray[i]);
            backtrack(charArray, i+1, res);

            charArray[i] = Character.toUpperCase(charArray[i]);
            backtrack(charArray, i+1, res);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();

        // Test cases
         String test1 = "a1b2"; // Expected: [a1b2, a1B2, A1b2, A1B2]
        String test2 = "3z4"; // Expected: [3z4, 3Z4]
        String test3 = "12345"; // Expected: [12345]
        String test4 = "0"; // Expected: [0]
        String test5 = "aBc"; // Expected: [abc, abC, aBc, aBC, Abc, AbC, ABc, ABC]

        System.out.println("Permutations for 'a1b2': " + lcp.letterCasePermutation(test1));
        System.out.println("Permutations for '3z4': " + lcp.letterCasePermutation(test2));
        System.out.println("Permutations for '12345': " + lcp.letterCasePermutation(test3));
        System.out.println("Permutations for '0': " + lcp.letterCasePermutation(test4));
        System.out.println("Permutations for 'aBc': " + lcp.letterCasePermutation(test5));
    }
}