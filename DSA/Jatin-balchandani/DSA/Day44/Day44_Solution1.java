import java.util.*;
public class Day44_Solution1 {


// User function Template for Java

        int getMinDiff(int arr[], int n, int k) {
            // code here
            Arrays.sort(arr);

            int diff=arr[n-1]-arr[0];
            int smallest=arr[0]+k;
            int largest=arr[n-1]-k;

            for ( int i=0;i<arr.length-1;i++){
                int mini= Math.min(smallest,arr[i+1]-k);
                int maxi=Math.max(largest,arr[i]+k);

                if( mini<0)
                    continue;

                diff=Math.min(diff,maxi-mini);
            }
            return diff;



        }
    }
