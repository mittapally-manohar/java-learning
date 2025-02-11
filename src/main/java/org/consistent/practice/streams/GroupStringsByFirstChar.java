package org.consistent.practice.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//TODO Group a list of strings by their first character using the Streams API.
public class GroupStringsByFirstChar {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("manohar", "tinku", "man", "tin", "boom");
        Function<String,Character> function = (s) -> s.charAt(0);
        Map<Character, List<String>> res = null;
        res = list.stream()
                .collect(Collectors.groupingBy(function));
        System.out.println(res);
    }
}
