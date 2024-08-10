// Split Array Largest Sum// File: Day51_Q2.java

public class Day51_Q2 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        Solution solution = new Solution();
        int result = solution.splitArray(nums, k);
        System.out.println("The minimum largest sum is: " + result);
    }
}

class Solution {
    public int cntNoOfSplits(int[] nums, int maxSum) {
        int noOfSplits = 1, sum = 0;
        for (int x : nums) {
            if (sum + x <= maxSum) {
                sum += x;
            } else {
                noOfSplits++;
                sum = x;
            }
        }
        return noOfSplits;
    }

    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE, end = 0, mid;
        for (int x : nums) {
            start = Math.max(start, x);
            end += x;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            int noOfSplits = cntNoOfSplits(nums, mid);
            if (noOfSplits <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
