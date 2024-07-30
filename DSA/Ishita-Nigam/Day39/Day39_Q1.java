//First Missing Positive
import java.util.Scanner;

public class Day39_Q1 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) nums[i] = n + 2;
            else if (nums[i] == 0) nums[i] = n + 3;
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val > n) continue;

            if (nums[val - 1] > 0) nums[val - 1] *= -1;
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            else ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        Day39_Q1 solution = new Day39_Q1();
        int result = solution.firstMissingPositive(nums);
        System.out.println("The first missing positive integer is: " + result);
    }
}
