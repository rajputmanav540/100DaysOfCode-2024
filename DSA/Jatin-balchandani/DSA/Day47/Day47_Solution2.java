import java.util.*;
public class Day47_Solution2 {


//User function Template for Java

        int median(int matrix[][], int R, int C) {
            // code here
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    q.add(matrix[i][j]);
                    if(q.size()>R*C/2+1)q.poll();
                }
            }
            return q.peek();
        }

}
