//Min Stack
import java.util.Stack;

public class Day66_Q2 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Day66_Q2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Day66_Q2 minStack = new Day66_Q2();

        // Test the push, pop, top, and getMin methods
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum: " + minStack.getMin()); // Expected output: -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());        // Expected output: 0
        System.out.println("Minimum: " + minStack.getMin()); // Expected output: -2
    }
}
