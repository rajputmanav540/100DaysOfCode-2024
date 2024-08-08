//Median in a row-wise sorted Matrix
// File: Day47_Q2.java
class Day47_Q2 {
    public int median(int[][] matrix, int R, int C) {
        // Finding the minimum and maximum values in the matrix
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            if (matrix[i][0] < min)
                min = matrix[i][0];

            if (matrix[i][C-1] > max)
                max = matrix[i][C-1];
        }

        // Finding the desired position of the median
        int desired = (R * C + 1) / 2;

        // Performing binary search to find the median
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;

            // Counting the number of elements smaller than or equal to the mid value
            for (int i = 0; i < R; ++i) {
                int l = 0, r = C-1;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (matrix[i][m] <= mid) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                if (matrix[i][l] <= mid) {
                    place++;
                }
                place += l;
            }

            // Adjusting the search range based on the number of elements found
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        
        // Returning the median (min value)
        return min;
    }

    // Optional main method for testing purposes
    public static void main(String[] args) {
        Day47_Q2 solution = new Day47_Q2();
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        int R = matrix.length;
        int C = matrix[0].length;
        int median = solution.median(matrix, R, C);
        System.out.println("Median is: " + median);
    }
}
