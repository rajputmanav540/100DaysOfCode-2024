import java.util.List;

class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long MOD = 1000000007;
        if (arr.size() == 1) {
            return arr.get(0) % MOD;
        }
        
        long product = 1;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        boolean hasPositive = false;
        
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            
            if (num < 0) {
                negativeCount++;
                maxNegative = Math.max(maxNegative, num);
            } else {
                hasPositive = true;
            }
            
            product = (product * num) % MOD;
        }
        
        if (zeroCount == arr.size() || (negativeCount == 1 && zeroCount + negativeCount == arr.size())) {
            return 0;
        }
        
        if (negativeCount % 2 != 0) {
            product = (product / maxNegative) % MOD;
        }
        
        if (product < 0) {
            product += MOD;
        }
        
        return product;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> arr1 = List.of(-1, 0, -2, 4, 3);
        List<Integer> arr2 = List.of(-1, 0);
        List<Integer> arr3 = List.of(5);
        
        System.out.println(solution.findMaxProduct(arr1)); // Output: 24
        System.out.println(solution.findMaxProduct(arr2)); // Output: 0
        System.out.println(solution.findMaxProduct(arr3)); // Output: 5
    }
}
