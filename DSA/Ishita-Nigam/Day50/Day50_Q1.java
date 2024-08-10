// Capacity To Ship Packages Within D Days

public class Day50_Q1 {
    public static void main(String[] args) {
        // Example usage
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        Solution solution = new Solution();
        int result = solution.shipWithinDays(weights, days);
        System.out.println("The minimum ship capacity needed is: " + result);
    }
}

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int beg = 1, end = 25_00_0000;

        while (beg < end) {
            int mid = (beg + end) / 2;

            if (shipAll(weights, mid, days)) {
                end = mid;
            } else {
                beg = mid + 1;
            }
        }

        return beg;
    }

    private boolean shipAll(int[] w, int c, int d) {
        int temp = c, count = 1;
        for (int i : w) {
            if (i > c) {
                return false;
            }

            if (i <= temp) {
                temp -= i;
            } else {
                temp = c - i;
                if (++count > d) {
                    return false;
                }
            }
        }

        return count <= d;
    }
}
