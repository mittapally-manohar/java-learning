package org.consistent.practice.streams;

import java.util.*;
import java.util.stream.*;

public class LessFrequently {

    /**
     * Convert a list of objects to a map using Streams.
     * @param objects List of objects
     * @return Map representation of objects
     * Sample Input: [("A", 1), ("B", 2), ("C", 3)]
     * Expected Output: {A=1, B=2, C=3}
     */
    public Map<String, Object> convertListToMap(List<Object> objects) {
       return objects.stream()
                .collect(Collectors.toMap(o -> ((Object[])o)[0].toString(), o -> ((Object[])o)[1]));
    }

    /**
     * Calculate the total salary of all employees.
     * @param employees List of employees
     * @return Total salary
     * Sample Input: [{name="John", salary=5000}, {name="Jane", salary=6000}]
     * Expected Output: 11000
     */
    public int calculateTotalSalary(List<Employee> employees) {
//        return employees.stream()
//                .map(Employee::getSalary)
//                .reduce(0, Integer::sum);
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    /**
     * Find the department with the highest number of employees.
     * @param employees List of employees
     * @return Department with most employees
     * Sample Input: [{name="John", department="HR"}, {name="Jane", department="IT"}, {name="Jim", department="IT"}]
     * Expected Output: IT
     */
    public String findLargestDepartment(List<Employee> employees) {
        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

       return departmentCount.entrySet().stream()
               .max(Map.Entry.comparingByValue())
               .stream()
               .map(Map.Entry::getKey)
               .findFirst()
               .orElse(null);
    }

    /**
     * Find the youngest and oldest employees in a list.
     * @param employees List of employees
     * @return Map with youngest and oldest employees
     * Sample Input: [{name="John", age=25}, {name="Jane", age=30}]
     * Expected Output: {youngest={name="John", age=25}, oldest={name="Jane", age=30}}
     */
    public Map<String, Employee> findYoungestAndOldest(List<Employee> employees) {
//        Map<String, Employee> result = new HashMap<>();
//        result.put("youngest", employees.stream()
//                .min(Comparator.comparingInt(Employee::getAge))
//                .orElse(null));
//        result.put("oldest", employees.stream()
//                .max(Comparator.comparingInt(Employee::getAge))
//                .orElse(null));
//        return result;
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge() == employees.stream()
                        .mapToInt(Employee::getAge)
                        .min()
                        .orElse(0) ? "youngest" : "oldest",
                        Collectors.collectingAndThen(Collectors.reducing((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2), Optional::get)));
    }

    /**
     * Check if a list contains only unique elements.
     * @param list List of elements
     * @return True if all elements are unique, otherwise false
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: true
     */
    public boolean containsOnlyUniqueElements(List<Integer> list) {
        // TODO: Implement this method
        return false;
    }

    /**
     * Find the longest word in a sentence using Streams.
     * @param sentence Input sentence
     * @return Longest word
     * Sample Input: "Java Streams are powerful"
     * Expected Output: "powerful"
     */
    public String findLongestWord(String sentence) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Convert a list to a Set using Streams.
     * @param list Input list
     * @return Converted set
     * Sample Input: [1, 2, 2, 3, 4, 4]
     * Expected Output: [1, 2, 3, 4]
     */
    public Set<Integer> convertListToSet(List<Integer> list) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Extract only vowels from a string using Streams.
     * @param input Input string
     * @return String containing only vowels
     * Sample Input: "hello world"
     * Expected Output: "eoo"
     */
    public String extractVowels(String input) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Reverse a list using Streams.
     * @param list Input list
     * @return Reversed list
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: [5, 4, 3, 2, 1]
     */
    public List<Integer> reverseList(List<Integer> list) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Implement a Stream pipeline to filter, transform, and collect data.
     * @param list Input list
     * @return Transformed list
     * Sample Input: [1, 2, 3, 4, 5]
     * Expected Output: ["2", "4"] (filter even, convert to string)
     */
    public List<String> streamPipelineExample(List<Integer> list) {
        // TODO: Implement this method
        return null;
    }

    // Sample Employee class
    public static class Employee {
        private String name;
        private int salary;
        private int age;
        private String department;

        public Employee(String name, int salary, int age, String department) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }

        public String getName() { return name; }
        public int getSalary() { return salary; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
    }

    public static void main(String[] args) {
        LessFrequently sp = new LessFrequently();

        // Test convertListToMap
        List<Object> objects = Arrays.asList(new Object[]{"A", 1}, new Object[]{"B", 2}, new Object[]{"C", 3});
        System.out.println(sp.convertListToMap(objects)); // Expected: {A=1, B=2, C=3}

        // Test calculateTotalSalary
        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000, 25, "HR"),
                new Employee("John", 5000, 25, "IT"),
                new Employee("Jane", 6000, 30, "IT")
        );
        System.out.println(sp.calculateTotalSalary(employees)); // Expected: 11000

        // Test findLargestDepartment
        System.out.println(sp.findLargestDepartment(employees)); // Expected: IT

        // Test findYoungestAndOldest
        System.out.println(sp.findYoungestAndOldest(employees)); // Expected: {youngest={name="John", age=25}, oldest={name="Jane", age=30}}

        // Test containsOnlyUniqueElements
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sp.containsOnlyUniqueElements(list)); // Expected: true

        // Test findLongestWord
        String sentence = "Java Streams are powerful";
        System.out.println(sp.findLongestWord(sentence)); // Expected: "powerful"

        // Test convertListToSet
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4);
        System.out.println(sp.convertListToSet(listWithDuplicates)); // Expected: [1, 2, 3, 4]

        // Test extractVowels
        String input = "hello world";
        System.out.println(sp.extractVowels(input)); // Expected: "eoo"

        // Test reverseList
        List<Integer> listToReverse = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sp.reverseList(listToReverse)); // Expected: [5, 4, 3, 2, 1]

        // Test streamPipelineExample
        List<Integer> listForPipeline = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sp.streamPipelineExample(listForPipeline)); // Expected: ["2", "4"]
    }
}
