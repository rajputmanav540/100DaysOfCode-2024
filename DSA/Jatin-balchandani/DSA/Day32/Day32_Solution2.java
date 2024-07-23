import java.util.*;

public class Day32_Solution2 {


        private static final int MOD = 1000000007;

        public long findMaxProduct(List<Integer> arr) {
            int n = arr.size();

            if (n == 1) {
                return arr.get(0) % MOD;
            }

            long maxProduct = 1;
            int negCount = 0;
            int zeroCount = 0;
            int maxNeg = Integer.MIN_VALUE;

            for (int num : arr) {
                if (num == 0) {
                    zeroCount++;
                } else {
                    if (num < 0) {
                        negCount++;
                        maxNeg = Math.max(maxNeg, num);
                    }
                    maxProduct = (maxProduct * num) % MOD;
                }
            }

            if (zeroCount == n) {
                return 0;
            }

            if (negCount == 1 && zeroCount + negCount == n) {
                return 0;
            }

            if (negCount % 2 != 0) {
                maxProduct = (maxProduct / maxNeg) % MOD;
            }

            return (maxProduct + MOD) % MOD;  // Handle negative results
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
