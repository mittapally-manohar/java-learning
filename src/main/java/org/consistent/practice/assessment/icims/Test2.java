package org.consistent.practice.assessment.icims;

public class Test2 {
    /**
     * Given the String S has text T and appended with length L of the text.
     *
     * eg: Bahubali8, where Bahubali is text and 8 is the length of this text.
     *
     *
     *
     * write logic to separate text and length from String S
     */
    public static void main(String[] args) {
        String s = "whereBahubali13";

        StringBuilder sb = new StringBuilder();
        String resStr = null;
        String length = null;
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));

            String rev = sb.reverse().toString();
            String remStr = s.substring(0,i);

            if (remStr.length() == Integer.parseInt(rev)){
                resStr = remStr;
                length = rev;
                break;
            }

        }

        System.out.println("String: "+resStr +" length: "+length);
    }
}
