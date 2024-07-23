//Number of Subarrays with Bounded Maximum
public class Day31_Q2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0, ans = 0, i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] > right) {
                count = 0;
                i = j + 1;
            } else if (nums[j] >= left && nums[j] <= right) {
                count = j - i + 1;
            }
            ans += count;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day31_Q2 solution = new Day31_Q2();
        int[] nums = { 2, 1, 4, 3 };
        int left = 2, right = 3;
        int result = solution.numSubarrayBoundedMax(nums, left, right);
        System.out.println("Number of subarrays with bounded maximum: " + result);
    }
}
