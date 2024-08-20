class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current temperature is higher
            // than the temperature at the index of the top element of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index; // Calculate the difference in days
            }
            stack.push(i); // Push the current index onto the stack
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }
        
        return answer;
    }
}
