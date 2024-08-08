//Orderly Queue
import java.util.Arrays;

public class Day45_Q2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.orderlyQueue("cba", 1)); // "acb"
        System.out.println(solution.orderlyQueue("baaca", 3)); // "aaabc"
    }
}

class Solution {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char S2[] = S.toCharArray();
            Arrays.sort(S2);
            return new String(S2);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res; 
    }
}
