//Row with max 1s
// File: Day48_Q1.java
public class Day48_Q1 {
    public static void main(String[] args) {
        // Example usage
        int[][] arr = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 0, 1}
        };

        Solution solution = new Solution();
        int result = solution.rowWithMax1s(arr);
        System.out.println("Row with maximum number of 1s is: " + result);
    }
}

class Solution {
    public int rowWithMax1s(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int maxRowIndex = -1;
        int maxCount = 0;

        for (int i = 0; i < N; ++i) {
            int count = 0;
            for (int j = 0; j < M; ++j) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }
}
