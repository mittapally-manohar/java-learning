package org.consistent.practice.assessment.arrise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,6);

        Map<Integer, Integer> map = input.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(Collectors.toMap(e->e, e-> e*e));

        System.out.println(map);
//        HashMap
    }
}
