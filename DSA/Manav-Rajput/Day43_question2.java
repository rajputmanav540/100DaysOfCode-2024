class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int maxIndex = 0; 
        int prefixAlignCount = 0; 
        
        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(maxIndex, flips[i]);
            if (maxIndex == i + 1) {
                prefixAlignCount++;
            }
        }
         return prefixAlignCount;
    }
}
