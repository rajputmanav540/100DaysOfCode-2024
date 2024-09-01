// Minimum Add to Make Parentheses Valid
import java.util.Stack;

public class Day62_Q2 {
    public int minAddToMakeValid(String S) {
        Stack<Character> s = new Stack<>();
        int c = 0;
        
        // Loop through each character in the string
        for (int i = 0; i < S.length(); i++) {
            // If character is '(', push it onto the stack
            if (S.charAt(i) == '(') {
                s.add(S.charAt(i));
            } 
            // If character is ')', handle balancing
            else {
                if (!s.isEmpty()) {
                    s.pop(); // Pop a '(' from stack if available
                } else {
                    c++; // Increment counter if there's no matching '('
                }
            }
        }
        
        // Add remaining unbalanced '(' to the counter
        c += s.size();
        
        return c;
    }
    
    // Main method for testing purposes
    public static void main(String[] args) {
        Day62_Q2 solution = new Day62_Q2();
        
        // Test cases
        String test1 = "())";
        String test2 = "(((";
        String test3 = "()";
        String test4 = "()))((";

        System.out.println("Test 1 Result: " + solution.minAddToMakeValid(test1)); // Output: 1
        System.out.println("Test 2 Result: " + solution.minAddToMakeValid(test2)); // Output: 3
        System.out.println("Test 3 Result: " + solution.minAddToMakeValid(test3)); // Output: 0
        System.out.println("Test 4 Result: " + solution.minAddToMakeValid(test4)); // Output: 4
    }
}

