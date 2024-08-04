class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
    }
    
    private int maxSum(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int maxFirstLen = 0;
        int result = 0;
        
        for (int i = firstLen + secondLen; i <= n; i++) {
            maxFirstLen = Math.max(maxFirstLen, prefixSum[i - secondLen] - prefixSum[i - secondLen - firstLen]);
            result = Math.max(result, maxFirstLen + (prefixSum[i] - prefixSum[i - secondLen]));
        }
        return result;
    }
}
