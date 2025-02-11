package org.consistent.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//Convert a list of strings to uppercase using the Streams API.
public class UpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("manohar", "tinku", "abc", "sldfasdf");
        Function<String, String> function = String::toUpperCase;
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
