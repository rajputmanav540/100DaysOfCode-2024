
// Spiral Matrix
import java.util.ArrayList;
import java.util.List;

public class Day46_Q2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(solution.spiralOrder(matrix1)); 

        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(solution.spiralOrder(matrix2)); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int strow = 0;
        int endrow = matrix.length - 1;
        int stcol = 0;
        int endcol = matrix[0].length - 1;
        while (strow <= endrow && stcol <= endcol) {
            for (int j = stcol; j <= endcol; j++) {
                list.add(matrix[strow][j]);
            }
            strow++;
            for (int i = strow; i <= endrow; i++) {
                list.add(matrix[i][endcol]);
            }
            endcol--;
            if (strow <= endrow) {
                for (int j = endcol; j >= stcol; j--) {
                    list.add(matrix[endrow][j]);
                }
                endrow--;
            }
            if (stcol <= endcol) {
                for (int i = endrow; i >= strow; i--) {
                    list.add(matrix[i][stcol]);
                }
                stcol++;
            }
        }
        return list;
    }
}
