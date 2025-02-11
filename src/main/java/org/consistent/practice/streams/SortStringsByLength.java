package org.consistent.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TODO Write a lambda expression to sort a list of strings by their length
public class SortStringsByLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("manohar", "tinku", "abc", "sldfasdf");
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}
