
//Koko Eating Bananas
import java.util.Arrays;

public class Day50_Q2 {
    public static void main(String[] args) {
        // Example usage
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;

        Solution solution = new Solution();
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("The minimum eating speed is: " + result);
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hour = 0;

            for (int pile : piles) {
                hour += (pile + mid - 1) / mid;
            }

            if (hour > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
                if (mid < min) {
                    min = mid;
                }
            }
        }

        return min;
    }
}
