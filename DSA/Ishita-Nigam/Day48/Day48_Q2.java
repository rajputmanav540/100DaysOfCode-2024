//Sorted matrix
// File: Day48_Q2.java
import java.util.Arrays;

public class Day48_Q2 {
    public static void main(String[] args) {
        // Example usage
        int[][] mat = {
            {10, 20, 30},
            {15, 25, 35},
            {27, 29, 37}
        };
        int n = mat.length;

        Solution solution = new Solution();
        int[][] sortedMat = solution.sortedMatrix(n, mat);

        // Print the sorted matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sortedMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    int[][] sortedMatrix(int n, int[][] mat) {
        // Temporary matrix of size n^2
        int[] temp = new int[n * n];
        int k = 0;

        // Copy the elements of matrix one by one into temp[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[k++] = mat[i][j];
            }
        }

        // Sort temp[]
        Arrays.sort(temp);

        // Copy the elements of temp[] one by one into mat[][]
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[k++];
            }
        }

        return mat;
    }
}
