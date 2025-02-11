package org.consistent.practice.challenge;

import java.util.*;

public class Challenge1 {
    public static String[] solution(String[] members, String[] messages) {
        Map<String, Integer> mentionCount = new HashMap<>();

        // Initialize mention count for all members
        for (String member : members) {
            mentionCount.put(member, 0);
        }

        // Process each message
        for (String message : messages) {
            // Use a set to track unique mentions per message
            Set<String> mentionedInMessage = new HashSet<>();
            
            // Extract mentions using regex
            String[] words = message.split("\\s+");
            for (String word : words) {
                if (word.startsWith("@")) {
                    String mention = word.substring(1); // Remove '@'
                    if (mentionCount.containsKey(mention)) {
                        mentionedInMessage.add(mention);
                    }
                }
            }

            // Update mention counts
            for (String mentioned : mentionedInMessage) {
                mentionCount.put(mentioned, mentionCount.get(mentioned) + 1);
            }
        }

        // Prepare the result
        List<String> result = new ArrayList<>();
        for (String member : members) {
            result.add(member + "=" + mentionCount.get(member));
        }

        // Sort by count (descending) and then by user ID (lexicographically)
        result.sort((a, b) -> {
            String[] partsA = a.split("=");
            String[] partsB = b.split("=");
            int countA = Integer.parseInt(partsA[1]);
            int countB = Integer.parseInt(partsB[1]);
            if (countA != countB) {
                return Integer.compare(countB, countA);
            }
            return partsA[0].compareTo(partsB[0]);
        });

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example inputs
        String[] members = {"id123", "id234", "id7", "id321"};
        String[] messages = {
            "Hey @id123,@id321 review this PR please! @id123 what do you think about this approach?",
            "Hey @id7 nice approach! Great job! @id800 what do you think?",
            "@id123,@id321 thx!"
        };

        // Call the solution method
        String[] output = solution(members, messages);
        System.out.println(Arrays.toString(output));
    }
}
