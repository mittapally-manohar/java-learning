package org.consistent.practice.assessment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondMax {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        System.out.println(list.stream()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .collect(Collectors.toList()));
//
//        List<String> list1 = Arrays.asList("manohar", "Rajesh");
//        System.out.println(list1.stream()
//                .sorted(Comparator.comparingInt(String::length).reversed())
//                .collect(Collectors.toList()));

//        String spaceStr = " hello   manohar    rajesh    ! ";
//
//        //hello manohar rajesh!
//
//        String[] strings = spaceStr.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for(String s: strings) {
//            if(!s.isEmpty()) {
//                sb.append(s).append(" ");
//            }
//        }
//        System.out.println(sb.substring(0, sb.length()-1));
//        evenOrOdd(integers);
//        removeDuplicates(integers);
//        frequencyOfCharacters(input);
//        sortInReverseOrder(integers);
//        mergeAndSort(a, b);
//        maxAndMin(integers);
//        anagram(input, input1);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 1);
        String input = "manohar";
        String input1 = "rahonams";
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{4,7,6};
        int i = 123;
        Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));

    }

    private static void anagram(String input, String input1) {
        String s1 = Stream.of(input.split("")).sorted().map(String::toUpperCase).collect(Collectors.joining());
        String s2 = Stream.of(input1.split("")).sorted().map(String::toUpperCase).collect(Collectors.joining());
        if(s1.equals(s2)){
            System.out.println("Anagram");
        }else{
            System.out.println("Not");
        }
    }

    private static void maxAndMin(List<Integer> integers) {
        System.out.println("max");
        integers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

        System.out.println("min");
        integers.stream().sorted().limit(3).forEach(System.out::println);
    }

    private static void mergeAndSort(int[] a, int[] b) {
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::print);
    }

    private static void sortInReverseOrder(List<Integer> integers) {
        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void frequencyOfCharacters(String input) {
        Map<Character, Long> res = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(res);
    }

    private static void removeDuplicates(List<Integer> integers) {
        List<Integer> uniqueInts = integers.stream()
                .distinct().collect(Collectors.toList());
        System.out.println(uniqueInts);
    }

    private static void evenOrOdd(List<Integer> integers) {
        Map<Boolean, List<Integer>> res = integers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        for (Map.Entry<Boolean, List<Integer>> map : res.entrySet()) {
            if (map.getKey()) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            for (Integer i : map.getValue()) {
                System.out.println(i);
            }
        }
    }
}
