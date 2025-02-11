package org.consistent.practice.challenge;

import java.util.*;

public class Main {
    public static int[] solution(String[] commands) {
        Map<String, Integer> commandCount = new HashMap<>(Map.of("cp", 0, "ls", 0, "mv", 0));
        List<String> history = new ArrayList<>();

        Arrays.stream(commands).forEach(command -> {
            String cmd = command.startsWith("!") ? history.get(Integer.parseInt(command.substring(1)) - 1) : command;
            history.add(cmd);
            commandCount.put(cmd, commandCount.get(cmd) + 1);
        });
        return new int[]{commandCount.get("cp"), commandCount.get("ls"), commandCount.get("mv")};
    }

    public static void main(String[] args) {
        String[] commands = {"ls", "cp", "mv", "mv", "mv", "!1", "!3", "!6"};
        int[] result = solution(commands);
        System.out.println(Arrays.toString(result)); // Output: [1, 3, 4]
    }
}
