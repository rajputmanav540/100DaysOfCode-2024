import java.util.*;
public class Day48_Solution2 {


// User function Template for Java

        int[][] sortedMatrix(int N, int Mat[][]) {
            // code here

            int b[] = new int[N * N];
            int m = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    b[m] = Mat[i][j];
                    m++;
                }
            }
            Arrays.sort(b);
            int curr = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Mat[i][j] = b[curr];
                    curr++;
                }
            }
            return Mat;

        }
    };
