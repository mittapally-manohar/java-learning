package org.consistent.practice.assessment;

public class StringReverse {
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(reverse(s,s.length()-1));
        System.out.println(palindrom(s,0,s.length()-1));
    }

    private static boolean palindrom(String s, int low, int high) {
        if (low >= high) {
            return true;
        }
        return s.charAt(low) == s.charAt(high) && palindrom(s, low + 1, high - 1);
    }

    private static String reverse(String s, int n) {
        if (s.equals("")){
            return "";
        }
        return s.charAt(n) + reverse(s.substring(0,n),n-1);
    }


}
