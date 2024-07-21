
// Maximum Product of Three Numbers
import java.util.Arrays;

public class Day30_Q1 {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int m2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(m1, m2);
    }

    public static void main(String[] args) {
        Day30_Q1 solution = new Day30_Q1();
        int[] nums = { 1, 2, 3, 4 };
        int result = solution.maximumProduct(nums);
        System.out.println("Maximum product of three numbers: " + result);
    }
}
