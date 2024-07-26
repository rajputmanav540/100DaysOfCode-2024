class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int upperLimit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        
        for (int k = 1; k <= upperLimit; k++) {
            if ((2 * n) % k == 0) {
                int a2 = (2 * n) / k - k + 1;
                if (a2 > 0 && a2 % 2 == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
