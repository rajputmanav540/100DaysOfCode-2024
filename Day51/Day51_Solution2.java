public class Day51_Solution2 {
        // Function to count the number of splits required if we limit the maximum sum of subarrays to maxSum
        public int cntNoOfSplits(int[] nums, int maxSum) {
            int noOfSplits = 1;  // Start with one split
            int currentSum = 0;  // Initialize the sum for the current split

            // Iterate through each number in the array
            for (int x : nums) {
                // If adding the current number doesn't exceed maxSum, add it to the current sum
                if (currentSum + x <= maxSum) {
                    currentSum += x;
                } else {
                    // Otherwise, we need a new split
                    noOfSplits++;
                    currentSum = x;  // Start a new split with the current number
                }
            }

            return noOfSplits;  // Return the total number of splits required
        }

        // Function to find the minimum possible largest sum after splitting the array into k subarrays
        public int splitArray(int[] nums, int k) {
            int start = Integer.MIN_VALUE;  // Minimum possible value for the largest subarray sum (the max element in nums)
            int end = 0;  // Maximum possible value for the largest subarray sum (sum of all elements in nums)

            // Determine the start (max single element) and end (sum of all elements) of our binary search range
            for (int x : nums) {
                start = Math.max(start, x);  // Update start to the maximum element in nums
                end += x;  // Sum all elements to get the end
            }

            // Perform binary search to find the minimum possible largest sum
            while (start <= end) {
                int mid = (start + end) / 2;  // Calculate the midpoint of the current range

                // Determine how many splits are needed with the current midpoint as the maximum sum
                int noOfSplits = cntNoOfSplits(nums, mid);

                // If the number of splits is within the allowed k, try for a smaller maximum sum
                if (noOfSplits <= k) {
                    end = mid - 1;
                } else {
                    // Otherwise, increase the minimum sum boundary
                    start = mid + 1;
                }
            }

            return start;  // Return the smallest possible maximum sum after the loop ends
        }
    }


