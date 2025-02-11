package org.consistent.practice.challenge;

import java.util.*;

public class ArrayListChallenge {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (Iterator i = list. iterator(); i. hasNext(); )
            System.out.println(i. next());
    }
}
