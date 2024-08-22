// Asteroid Collision
import java.util.Stack;

public class Day62_Q1 {

    public static void main(String[] args) {
        // Example input
        int[] asteroids = {5, 10, -5};

        // Create an instance of the solution and run the method
        Day62_Q1 solution = new Day62_Q1();
        int[] result = solution.asteroidCollision(asteroids);

        // Print the result
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
                alive = false;
                break;
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
