public class Day51_Solution1 {
        public int smallestDivisor(int[] nums, int threshold) {
            // Initial boundaries for binary search
            int left = 1;
            int right = getMax(nums);

            // Perform binary search
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (computeSum(nums, mid) <= threshold) {
                    right = mid - 1;  // Try for a smaller divisor
                } else {
                    left = mid + 1;  // Increase the divisor
                }
            }

            return left;  // Smallest divisor found
        }

        // Helper function to find the maximum value in the array
        private int getMax(int[] nums) {
            int max = nums[0];
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

        // Helper function to compute the sum of the ceiling of each division
        private int computeSum(int[] nums, int divisor) {
            int sum = 0;
            for (int num : nums) {
                sum += (num + divisor - 1) / divisor;  // Equivalent to Math.ceil((double)num / divisor)
            }
            return sum;
        }
    }

