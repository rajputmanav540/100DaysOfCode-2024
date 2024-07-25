class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long maxProduct = 1;
        long minNegative = Long.MAX_VALUE;
        int countNegative = 0;
        int countZero = 0;
        long productWithoutZero = 1;
        final int MOD = 1000000007;
        if (arr.size() == 1) {
            return arr.get(0);
        }

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNegative++;
                minNegative = Math.min(minNegative, Math.abs((long)num));
            }
            productWithoutZero =(productWithoutZero* num)% MOD;
        }
        if (countZero == arr.size()) {
            return 0;
        }
        if (productWithoutZero > 0) {
            return productWithoutZero;
        }
        if (countNegative == 1 && countZero + countNegative == arr.size()) {
            return 0;
        }
        return productWithoutZero / (-minNegative);
    }
    
}
