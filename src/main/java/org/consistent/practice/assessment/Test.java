package org.consistent.practice.assessment;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String input = "Hi How are you Manohar Mittapally";
        System.out.println(input.chars().filter(s -> s == 'a').count());
        // find the common character from above string for a, e, i, o, u, z
        List<Character> vowelsAndZ = Arrays.asList('a', 'e', 'i', 'o', 'u', 'z', 'm');

        vowelsAndZ.forEach(ch -> {
            long count = input.chars()
                    .filter(c -> c == ch)
                    .count();
            System.out.println(ch + " " + count);
        });
//        String input = "Hi How are you Manohar Mittapally";
//        //find the common character from above string for a,e,i,o,u,z
//        String p = "aeiouz";
//
//        Map<Character, Integer> pmap = new HashMap<>();
//        for (char ch : p.toCharArray()) {
//            pmap.put(ch,0);
//        }
//
//       Map<Character, Integer> s3 =input.chars().mapToObj(i-> (char)i)
//               .map(s1-> {
//                   if (pmap.containsKey(s1)) {
//                       pmap.put(s1, pmap.get(s1)+1);
//                   }
//                   return s1;
//               }).collect(Collectors.toMap(s1->s1,s1->1,(s1,s2)->s1));
//
//        pmap.entrySet().stream().forEach(s-> System.out.println(s.getKey()+" "+s.getValue()));
//        for (char ch : input.toCharArray()) {
//            if(pmap.containsKey(ch)){
//                pmap.put(ch, pmap.get(ch) + 1);
//            }
//        }
//
//        pmap.entrySet().stream().forEach(s-> System.out.println(s.getKey()+" "+s.getValue()));


//        List<String> s= Arrays.asList(input.split(""));
//        s.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .map(s2-> {
//                    for(int i=0;i<p.length();i++){
//                        if(s2.getKey().equalsIgnoreCase(String.valueOf(p.charAt(i)))){
//                            return s2;
//                        }else {
//
//                        }
//                    }
//                })
//                .filter(map -> {
//                    if(map.getKey().matches("[aeiouz]+")){
//                        return true;
//                    }return false;
//                }).forEach(s1-> System.out.println("Key: "+s1.getKey()+" Value: "+s1.getValue()));
        List<String> s = Arrays.asList(input.split(""));
        s.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> {
                    if (map.getKey().matches("[aeiouz]+")) {
                        return true;
                    }
                    return false;
                }).forEach(s1 -> System.out.println("Key: " + s1.getKey() + " Value: " + s1.getValue()));

    }
}
