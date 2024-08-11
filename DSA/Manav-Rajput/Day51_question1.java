class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (computeSum(nums, mid, threshold) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    private int computeSum(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) {
                return sum; // Early exit if sum exceeds threshold
            }
        }
        return sum;
    }
}
