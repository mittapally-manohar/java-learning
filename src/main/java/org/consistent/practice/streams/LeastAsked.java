package org.consistent.practice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.*;

public class LeastAsked {

    /**
     * Calculate the factorial of a number using Streams.
     * @param number Input number
     * @return Factorial of the number
     * Sample Input: 5
     * Expected Output: 120
     */
    public int calculateFactorial(int number) {
        return Stream.iterate(1, i -> i+1)
                .limit(number)
                .reduce(1, (a,b) -> a * b);
    }

    /**
     * Find if a given string is a palindrome using Streams.
     * @param str Input string
     * @return True if the string is a palindrome, otherwise false
     * Sample Input: "racecar"
     * Expected Output: true
     */
    public boolean isPalindrome(String str) {
       String reverseStr=str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst ->
                {
                    Collections.reverse(lst);
                    return lst.stream();
                }))
               .map(String::valueOf)
                .collect(Collectors.joining());
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    /**
     * Generate Fibonacci series using Streams.
     * @param limit Number of elements in the series
     * @return List of Fibonacci numbers
     * Sample Input: 5
     * Expected Output: [0, 1, 1, 2, 3]
     */
    public List<Integer> generateFibonacci(int limit) {
        UnaryOperator<int[]> operator = new UnaryOperator<int[]>() {
            @Override
            public int[] apply(int[] ints) {
                return new int[]{ints[1], ints[0]+ints[1]};
            }
        };
        return Stream.iterate(new int[]{0,1},x -> new int[]{x[0], x[0]+x[1]})
                .limit(limit)
                .map(fib -> fib[0])
                .collect(Collectors.toList());
    }

    /**
     * Implement a custom collector in Streams.
     * @param list List of integers
     * @return Custom collected result
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: Custom result based on the collector
     */
    public Object customCollector(List<Integer> list) {
        Collector<Integer, ?, Integer> sumOfSquares = Collectors.reducing(1, i-> i*i, Integer::sum);
        return list.stream()
                .collect(sumOfSquares);
    }

    /**
     * Use reduce() to concatenate a list of strings.
     * @param strings List of strings
     * @return Concatenated string
     * Sample Input: ["a", "b", "c"]
     * Expected Output: "abc"
     */
    public String concatenateStrings(List<String> strings) {
        return strings.stream()
//                .reduce("", (a,b) -> a+b);
                .collect(Collectors.joining());
    }

    /**
     * Parallel processing using parallelStream().
     * @param list List of integers
     * @return Processed list
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: Processed list with parallelStream
     */
    public List<Integer> parallelProcessing(List<Integer> list) {
        return list.parallelStream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    /**
     * Find the Kth largest element in a list using Streams.
     * @param list List of integers
     * @param k The Kth position
     * @return Kth largest element
     * Sample Input: [1, 3, 4, 5, 0, 2], 2
     * Expected Output: 4
     */
    public Integer findKthLargest(List<Integer> list, int k) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst()
                .orElse(null);
    }

    /**
     * Convert a Map to a List using Streams.
     * @param map Input map
     * @return List of map entries
     * Sample Input: {1="one", 2="two"}
     * Expected Output: ["1=one", "2=two"]
     */
    public List<String> convertMapToList(Map<Integer, String> map) {
        return map.entrySet().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    /**
     * Extract all unique words from a given paragraph using Streams.
     * @param paragraph Input paragraph
     * @return List of unique words
     * Sample Input: "hello world hello"
     * Expected Output: ["hello", "world"]
     */
    public List<String> extractUniqueWords(String paragraph) {
//        return Arrays.stream(paragraph.split(" "))
//                .distinct()
//                .collect(Collectors.toList());
        return new ArrayList<>(Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                .collect(Collectors.toCollection(TreeSet::new)));
    }

    /**
     * Find the common elements between multiple lists using Streams.
     * @param lists List of lists
     * @return List of common elements
     * Sample Input: [[1, 2, 3,4], [2, 3, 4], [3, 4, 5]]
     * Expected Output: [3]
     */
    public List<Integer> findCommonElements(List<List<Integer>> lists) {
        List<Set<Integer>> input = lists.stream()
                .map(HashSet::new)
                .collect(Collectors.toList());

        return input.stream()
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == lists.size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LeastAsked sq = new LeastAsked();

        // Test calculateFactorial
        System.out.println(sq.calculateFactorial(5)); // Expected: 120

        // Test isPalindrome
        System.out.println(sq.isPalindrome("racecar")); // Expected: true

        // Test generateFibonacci
        System.out.println(sq.generateFibonacci(5)); // Expected: [0, 1, 1, 2, 3]

        // Test customCollector
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sq.customCollector(list)); // Expected: Custom result based on the collector

        // Test concatenateStrings
        List<String> strings = Arrays.asList("a", "b", "c");
        System.out.println(sq.concatenateStrings(strings)); // Expected: "abc"

        // Test parallelProcessing
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sq.parallelProcessing(numbers)); // Expected: Processed list with parallelStream

        // Test findKthLargest
        List<Integer> numbersForKthLargest = Arrays.asList(1, 3, 4, 5, 0, 2);
        System.out.println(sq.findKthLargest(numbersForKthLargest, 2)); // Expected: 4

        // Test convertMapToList
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        System.out.println(sq.convertMapToList(map)); // Expected: ["1=one", "2=two"]

        // Test extractUniqueWords
        String paragraph = "hello world hello";
        System.out.println(sq.extractUniqueWords(paragraph)); // Expected: ["hello", "world"]

        // Test findCommonElements
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3,3), Arrays.asList(2, 1, 4), Arrays.asList(3, 4, 5));
        System.out.println(sq.findCommonElements(lists)); // Expected: [3]
    }
}