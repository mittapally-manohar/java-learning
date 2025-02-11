package org.consistent.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

//TODO: Use the Streams API to find the sum of all even numbers in a list.
public class SumOfEvenNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        //supplier example
        Supplier<Integer> supplier = () -> 0;
        int res = list.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum).orElseGet(supplier);
        System.out.println(res);
    }
}
