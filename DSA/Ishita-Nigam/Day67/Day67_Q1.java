// Minimum Cost Tree From Leaf Values
import java.util.Stack;

public class Day67_Q1 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                int mid = stack.pop();
               
                if (stack.isEmpty()) {
                    sum += mid * num;
                } else {
                    sum += mid * Math.min(num, stack.peek());
                }
            }
            stack.push(num);
        }

        while (stack.size() > 1) {
            int mid = stack.pop();
            sum += stack.peek() * mid;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Example usage of the mctFromLeafValues method
        Day67_Q1 solution = new Day67_Q1();
        int[] arr = {6, 2, 4};
        int result = solution.mctFromLeafValues(arr);
        
        System.out.println(result); // Output should be 32
    }
}
