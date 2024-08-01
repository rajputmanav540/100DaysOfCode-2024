class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long mod = 1_000_000_007;
        long[] powerOfTwo = new long[n];
        
        powerOfTwo[0] = 1;
        for (int i = 1; i < n; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % mod;
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i] * (powerOfTwo[i] - powerOfTwo[n - 1 - i]) % mod) % mod;
        }
        
        return (int)((sum + mod) % mod);
    }
}
