//Validate Stack Sequences
import java.util.Stack;

public class Day65_Q2 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false; 
        
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // Pop all elements from stack which are the same as in the popped array
            while (popIndex < popped.length // boundary check
                    && !stack.isEmpty() // stack should not be empty
                    && popped[popIndex] == stack.peek()) // popped element must be the current element in popped array
            {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty(); // stack should be empty at last
    }

    public static void main(String[] args) {
        Day65_Q2 solution = new Day65_Q2();
        
        // Test case
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        
        boolean result = solution.validateStackSequences(pushed, popped);
        System.out.println("Is the sequence valid? " + result);
    }
}
