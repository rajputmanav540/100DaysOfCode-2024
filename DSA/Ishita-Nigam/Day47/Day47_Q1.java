// Search a 2D Matrix
// File: Day47_Q1.java
class Day47_Q1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if (matrix[i][j] == target) {
                return true;
            } else if (target < matrix[i][j]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // Optional main method for testing purposes
    public static void main(String[] args) {
        Day47_Q1 solution = new Day47_Q1();
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 5;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
