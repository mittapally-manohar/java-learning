package org.consistent.practice.assessment.icims;

public class Test {
    /**
     * Compress the string "aabcccccaaa" into "a2b1c5a3" with minimal space complexity
     */
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        StringBuilder res = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                res.append(c).append(count);
                c= s.charAt(i);
                count = 1;
            }
        }
        res.append(c).append(count);

        System.out.println(res.toString());
    }
}
