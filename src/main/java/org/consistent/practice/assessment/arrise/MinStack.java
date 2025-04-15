package org.consistent.practice.assessment.arrise;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack, min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty()) min.push(x);
        else if (min.peek() >= x) min.push(x);
    }

    public void pop() {
        int popped = stack.pop();
        if (!min.empty() && min.peek() == popped) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Output: 3
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Output: 1
        minStack.pop();
        System.out.println("Current Min: " + minStack.getMin()); // Output: 2
        System.out.println("Top Element: " + minStack.top());    // Output: 5
        System.out.println("Current Min: " + minStack.getMin()); // Output: 3
    }
}        