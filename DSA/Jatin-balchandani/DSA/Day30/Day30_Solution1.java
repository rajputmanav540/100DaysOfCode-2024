import java.util.Arrays;
public class Day30_Solution1 {



        public int maximumProduct(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            // Consider the product of the three largest numbers
            int max1 = nums[n-1] * nums[n-2] * nums[n-3];
            // Consider the product of the two smallest numbers and the largest number
            int max2 = nums[0] * nums[1] * nums[n-1];
            // Return the maximum of the two
            return Math.max(max1, max2);
        }

}
