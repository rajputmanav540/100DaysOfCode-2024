import java.util.*;
public class Day49_Solution2 {


//User function Template for Java


        public static int kthSmallest(int[][]mat,int n,int k)
        {
            //code here.
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    al.add(mat[i][j]);
                }
            }
            Collections.sort(al);

            return al.get(k-1);
        }

    }
