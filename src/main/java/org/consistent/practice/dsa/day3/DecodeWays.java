package org.consistent.practice.dsa.day3;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int oldState = 1;
        int newState = 1;
        for(int i=1;i<s.length();i++){
            int count = 0;
            if(s.charAt(i)!='0') count=newState;
            int twoDigit = Integer.parseInt(s.substring(i-1,i+1));
            if(twoDigit>=10 && twoDigit<=26){
                count+=oldState;
            }
            oldState = newState;
            newState = count;
        }
        return newState;
    }
}
