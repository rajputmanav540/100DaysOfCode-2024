// Find Minimum in Rotated Sorted Array
public class Day54_Q1 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum value: " + solution.findMin(nums));
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
