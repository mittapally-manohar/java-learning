package org.consistent.practice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostAsked {

    /**
     * Convert a List of Strings to Uppercase using Streams.
     *
     * @param strings List of strings
     * @return List of uppercase strings
     * Sample Input: ["hello", "world"]
     * Expected Output: ["HELLO", "WORLD"]
     */
    public List<String> convertToUppercase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Find the second-highest number in a list of integers.
     *
     * @param numbers List of integers
     * @return Second-highest number
     * Sample Input: [1, 3, 4, 5, 0, 2]
     * Expected Output: 4
     */
    public Integer findSecondHighest(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    /**
     * Remove duplicates from a list using Streams.
     *
     * @param list List of integers
     * @return List without duplicates
     * Sample Input: [1, 2, 2, 3, 4, 4, 5]
     * Expected Output: [1, 2, 3, 4, 5]
     */
    public List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Find the first non-repeating character in a string using Streams.
     *
     * @param str Input string
     * @return First non-repeating character
     * Sample Input: "swiss"
     * Expected Output: 'w'
     */
    public Character findFirstNonRepeatingChar(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseGet(() -> null);
    }

    /**
     * Find the first repeating character in a string using Streams.
     *
     * @param str Input string
     * @return First repeating character
     * Sample Input: "swiss"
     * Expected Output: 's'
     */
    public Character findFirstRepeatingChar(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 1)
                .map(map -> map.getKey())
                .findFirst()
                .orElse(null);
    }

    /**
     * Sort a list of integers in ascending and descending order.
     *
     * @param numbers List of integers
     * @return Map with sorted lists
     * Sample Input: [5, 3, 8, 1, 2]
     * Expected Output: {ascending=[1, 2, 3, 5, 8], descending=[8, 5, 3, 2, 1]}
     */
    public Map<String, List<Integer>> sortList(List<Integer> numbers) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> ascending = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        map.put("ascending",ascending);
        map.put("descending", descending);
        return map;
    }

    /**
     * Find the maximum and minimum values in a list using Streams.
     *
     * @param numbers List of integers
     * @return Map with max and min values
     * Sample Input: [5, 3, 8, 1, 2]
     * Expected Output: {max=8, min=1}
     */
    public Map<String, Integer> findMaxMin(List<Integer> numbers) {
        Map<String, Integer> map = new HashMap<>();
        int min = numbers.stream()
                .min(Integer::compareTo)
                .get();
        int max = numbers.stream()
                .max(Integer::compareTo)
                .get();
        IntSummaryStatistics stats = numbers.stream()
                        .mapToInt(Integer::intValue)
                                .summaryStatistics();
        map.put("max", stats.getMax());
        map.put("min",stats.getMin());
        return map;
    }

    /**
     * Find the sum and average of a list of numbers.
     *
     * @param numbers List of integers
     * @return Map with sum and average
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: {sum=15, average=3.0}
     */
    public Map<String, Number> findSumAndAverage(List<Integer> numbers) {
       IntSummaryStatistics stats= numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
       Map<String, Number> map = new HashMap<>();
       map.put("sum", stats.getSum());
       map.put("average", stats.getAverage());
        return map;
    }

    /**
     * Group a list of people by age using Collectors.groupingBy().
     *
     * @param people List of people
     * @return Map grouped by age
     * Sample Input: [{name="John", age=30}, {name="Jane", age=25}, {name="Doe", age=30}]
     * Expected Output: {30=[{name="John", age=30}, {name="Doe", age=30}], 25=[{name="Jane", age=25}]}
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> people) {
        // TODO: Implement this method
        return people.stream()
                .collect(Collectors.groupingBy(Person::getAge, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * Find all even and odd numbers from a list using Streams.
     *
     * @param numbers List of integers
     * @return Map with even and odd numbers
     * Sample Input: [1, 2, 3, 4, 5, 6]
     * Expected Output: {even=[2, 4, 6], odd=[1, 3, 5]}
     */
    public Map<String, List<Integer>> findEvenAndOdd(List<Integer> numbers) {
        Map<Boolean, List<Integer>> map =numbers.stream()
                .collect(Collectors.partitioningBy(e->e%2==0));

        Map<String, List<Integer>> stringMap = new HashMap<>();
        stringMap.put("even", map.get(true));
        stringMap.put("odd", map.get(false));

        Map<Person, Integer> map1 = new HashMap<>();
        map1.put(new Person("Manohar", 29),29);
        map1.put(new Person("Manohar", 29),29);
        map1.put(new Person("Manohar", 29),29);

        System.out.println("size "+map1.size());

        return stringMap;


    }

    // Sample Person class for groupByAge method
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        MostAsked sq = new MostAsked();

        // Test convertToUppercase
        List<String> strings = Arrays.asList("hello", "world");
        System.out.println(sq.convertToUppercase(strings)); // Expected: ["HELLO", "WORLD"]

        // Test findSecondHighest
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 0, 2);
        System.out.println(sq.findSecondHighest(numbers)); // Expected: 4

        // Test removeDuplicates
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(sq.removeDuplicates(listWithDuplicates)); // Expected: [1, 2, 3, 4, 5]

        // Test findFirstNonRepeatingChar
        String str1 = "swiss";
        System.out.println(sq.findFirstNonRepeatingChar(str1)); // Expected: 'w'

        // Test findFirstRepeatingChar
        String str2 = "swiss";
        System.out.println(sq.findFirstRepeatingChar(str2)); // Expected: 's'

        // Test sortList
        List<Integer> unsortedNumbers = Arrays.asList(5, 3, 8, 1, 2);
        System.out.println(sq.sortList(unsortedNumbers)); // Expected: {ascending=[1, 2, 3, 5, 8], descending=[8, 5, 3, 2, 1]}

        // Test findMaxMin
        List<Integer> numbersForMaxMin = Arrays.asList(5, 3, 8, 1, 2);
        System.out.println(sq.findMaxMin(numbersForMaxMin)); // Expected: {max=8, min=1}

        // Test findSumAndAverage
        List<Integer> numbersForSumAvg = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sq.findSumAndAverage(numbersForSumAvg)); // Expected: {sum=15, average=3.0}

        // Test groupByAge
        List<Person> people = Arrays.asList(new Person("John", 30), new Person("Jane", 25), new Person("Doe", 30));
        System.out.println(sq.groupByAge(people)); // Expected: {30=[{name="John", age=30}, {name="Doe", age=30}], 25=[{name="Jane", age=25}]}

        // Test findEvenAndOdd
        List<Integer> numbersForEvenOdd = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sq.findEvenAndOdd(numbersForEvenOdd)); // Expected: {even=[2, 4, 6], odd=[1, 3, 5]}
    }
}