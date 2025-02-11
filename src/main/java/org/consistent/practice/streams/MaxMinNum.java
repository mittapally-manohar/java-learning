package org.consistent.practice.streams;

import java.util.Arrays;
import java.util.List;

//TODO Find the maximum and minimum values in a list of integers using the Streams API
public class MaxMinNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("min: " + list.stream().min(Integer::compareTo).get());
        System.out.println("max: " + list.stream().max(Integer::compareTo).get());
    }
}
