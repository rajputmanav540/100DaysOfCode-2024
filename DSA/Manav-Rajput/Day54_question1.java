class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated at all
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid+1 is the minimum element
            if (mid < right && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Check if mid is the minimum element
            if (mid > left && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Decide whether to go to the left half or the right half
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left]; // After the loop, left should be the minimum
    }
}
