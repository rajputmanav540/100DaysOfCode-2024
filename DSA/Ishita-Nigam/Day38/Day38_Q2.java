
//Row with max 1s
import java.util.Scanner;

public class Day38_Q2 {
    public int rowWithMax1s(int arr[][]) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];
        System.out.println("Enter the matrix elements (0 or 1):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        Day38_Q2 solution = new Day38_Q2();
        int result = solution.rowWithMax1s(arr);
        System.out.println("Row with the maximum number of 1s: " + result);
    }
}
