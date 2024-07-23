
//Maximum product subset of an array
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Day32_Q2 {
    public static class Solution {
        public long findMaxProduct(List<Integer> arr) {
            final int MOD = 1000000007;
            if (arr.size() == 1)
                return arr.get(0) % MOD;
            long maxProduct = 1;
            int negativeCount = 0;
            int zeroCount = 0;
            int maxNegative = Integer.MIN_VALUE;

            for (int num : arr) {
                if (num == 0) {
                    zeroCount++;
                    continue;
                }
                if (num < 0) {
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, num);
                }
                maxProduct = (maxProduct * num) % MOD;
            }

            if (zeroCount == arr.size())
                return 0;

            if (negativeCount % 2 != 0) {
                if (negativeCount == 1 && zeroCount + negativeCount == arr.size())
                    return 0;
                maxProduct = (maxProduct / maxNegative) % MOD;
            }

            if (maxProduct < 0)
                maxProduct += MOD;

            return maxProduct;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            Solution sol = new Solution();
            long ans = sol.findMaxProduct(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
