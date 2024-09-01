// Largest Rectangle in Histogram
import java.util.Stack;

public class Day61_Q1 {

    public static void main(String[] args) {
        // Example input
        int[] heights = {2, 1, 5, 6, 2, 3};

        // Create an instance of the solution and run the method
        Day61_Q1 solution = new Day61_Q1();
        int result = solution.largestRectangleArea(heights);

        // Print the result
        System.out.println("Largest Rectangle Area: " + result);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
