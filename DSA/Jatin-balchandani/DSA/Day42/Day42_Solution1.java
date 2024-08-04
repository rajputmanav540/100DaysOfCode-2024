import java.util.*;
public class Day42_Solution1 {

        public static int kthSmallest(int[] arr, int l, int r, int k)
        {
            //Your code here
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i< (r-l+1); i++){
                pq.add(arr[i]);
            }
            while(pq.size()>k){
                pq.poll();
            }
            return pq.peek();
        }
    }

