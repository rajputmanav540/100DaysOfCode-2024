// Kth element in Matrix
public class Day49_Q2 {
    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int n = 3; // Number of rows/columns
        int k = 8; // k-th smallest element to find

        int result = Solution.kthSmallest(matrix, n, k);
        System.out.println("The " + k + "-th smallest element is: " + result);
    }
}

class Solution {
    public static int kthSmallest(int[][] matrix, int n, int k) {
        int l = matrix[0][0];
        int h = matrix[matrix.length - 1][matrix[0].length - 1];
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (rank(matrix, mid) < k) {
                l = mid + 1;
            } else {
                ans = mid;
                h = mid - 1;
            }
        }
        return ans;
    }

    private static int rank(int[][] matrix, int mid) {
        int i = 0;
        int r = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > mid) {
                j--;
            } else {
                r += j + 1;
                i++;
            }
        }
        return r;
    }
}
