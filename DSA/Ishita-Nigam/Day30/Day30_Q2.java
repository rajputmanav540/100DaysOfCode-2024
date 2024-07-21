//Largest Number At Least Twice of Others
public class Day30_Q2 {
    public int dominantIndex(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }
        }

        return max1 >= max2 * 2 ? maxIndex : -1;
    }

    public static void main(String[] args) {
        Day30_Q2 solution = new Day30_Q2();
        int[] nums = { 3, 6, 1, 0 };
        int result = solution.dominantIndex(nums);
        System.out.println("Index of the dominant element: " + result);
    }
}
