class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        
        for (int num : pushed) {
            stack.push(num); // Push the current element onto the stack
            
            // Check if the top of the stack matches the next element in the popped array
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop(); // Pop the element from the stack
                popIndex++;  // Move to the next element in the popped array
            }
        }
        
        // If all elements have been successfully popped, the sequence is valid
        return stack.isEmpty();
    }
}
