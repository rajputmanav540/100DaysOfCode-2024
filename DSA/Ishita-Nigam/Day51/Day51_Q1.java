//Find the Smallest Divisor Given a Threshold
// File: Day51_Q1.java
import java.util.Arrays;

public class Day51_Q1 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        Solution solution = new Solution();
        int result = solution.smallestDivisor(nums, threshold);
        System.out.println("The smallest divisor is: " + result);
    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums.length == threshold) {
            return Arrays.stream(nums).max().getAsInt();
        }
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int min = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int time = 0;
            for (int i : nums) {
                time += (i + mid - 1) / mid;
            }
            if (time <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
