public class Day48_Solution1 {


// User function Template for Java

        public int rowWithMax1s(int arr[][]) {
            // code here
            int n = arr.length;
            int m = arr[0].length;

            int maxRowIndex = -1;
            int maxOnesCount = 0;
            int j = m - 1;  // Start from the top-right corner

            for (int i = 0; i < n; i++) {
                while (j >= 0 && arr[i][j] == 1) {
                    j--;  // Move left to count 1s in the current row
                }
                int onesCount = m - 1 - j;
                if (onesCount > maxOnesCount) {
                    maxOnesCount = onesCount;
                    maxRowIndex = i;
                }
            }

            return maxRowIndex;
        }
    }
