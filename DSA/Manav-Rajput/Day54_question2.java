class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare middle element with the rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum must be to the right of mid
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum could be mid or to the left of mid
                right = mid;
            } else {
                // If nums[mid] == nums[right], we can't be sure of the minimum's position
                // But we can safely discard nums[right] as it is not the minimum
                right--;
            }
        }
        
        return nums[left];
    }
}
