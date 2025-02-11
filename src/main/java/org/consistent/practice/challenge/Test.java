package org.consistent.practice.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1,2,3,4,5
        //4
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer result = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(result);
    }
}
