// Daily Temperatures

import java.util.Stack;

class Day60_Q2 {

    // Function to calculate the number of days until a warmer temperature
    public int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length]; // Array to store the results
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of temperatures

        // Traverse through the temperature array
        for (int i = 0; i < temps.length; i++) {
            // While stack is not empty and the current temperature is warmer than the temperature at the index stored in the stack
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop(); // Calculate the difference and store in results
            }
            stack.push(i); // Push the current index onto the stack
        }

        return results;
    }

    // Main method to test the dailyTemperatures function
    public static void main(String[] args) {
        Day60_Q2 solution = new Day60_Q2();

        // Example input array
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};

        // Call the dailyTemperatures function
        int[] result = solution.dailyTemperatures(temps);

        // Print the result
        System.out.print("Days to warmer temperature: ");
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
