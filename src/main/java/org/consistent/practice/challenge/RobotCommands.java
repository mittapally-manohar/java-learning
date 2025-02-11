package org.consistent.practice.challenge;

public class RobotCommands {
    public static String solution(String commands) {
        int position = commands.chars().map(c -> c == 'L' ? -1 : 1).sum();
        return position < 0 ? "L" : position > 0 ? "R" : "";
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(solution("RLLRLL"));    // Output: "L"
        System.out.println(solution("LLRRLLRR"));  // Output: ""
    }
}
