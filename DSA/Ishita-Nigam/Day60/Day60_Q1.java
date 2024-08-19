// Next Greater Element II

import java.util.Arrays;
import java.util.Stack;

class Day60_Q1 {

    // Function to find the next greater elements in a circular array
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);  // Fill the answer array with -1 initially

        // Loop through the array twice to simulate the circular nature
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;  // Get the current index in the circular array

            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }

            // If the stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                ans[idx] = stack.peek();
            }

            // Push the current element onto the stack
            stack.push(nums[idx]);
        }

        return ans;
    }

    // Main method to test the nextGreaterElements function
    public static void main(String[] args) {
        Day60_Q1 solution = new Day60_Q1();

        // Example input array
        int[] nums = {1, 2, 1};

        // Call the nextGreaterElements function
        int[] result = solution.nextGreaterElements(nums);

        // Print the result
        System.out.println("Next greater elements: " + Arrays.toString(result));
    }
}
