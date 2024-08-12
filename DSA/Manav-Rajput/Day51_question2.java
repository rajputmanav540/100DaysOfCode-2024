class Solution {
    public int splitArray(int[] nums, int k) {
        int left = getMax(nums); // minimum possible largest sum
        int right = getSum(nums); // maximum possible largest sum
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; // mid might be the answer, so move right boundary to mid
            } else {
                left = mid + 1; // mid is too small, increase left boundary
            }
        }
        
        return left;
    }
    
    // Helper function to find the maximum element in the array
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    // Helper function to find the sum of elements in the array
    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    
    // Helper function to check if we can split the array into `k` or fewer subarrays
    // with each subarray having a sum less than or equal to `maxSum`
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int splits = 1;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                splits++;
                currentSum = num;
                if (splits > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
