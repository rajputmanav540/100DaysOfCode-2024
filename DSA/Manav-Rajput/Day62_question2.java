public class Solution {
    public int minAddToMakeValid(String s) {
        int leftUnmatched = 0;  // Counter for unmatched '('
        int rightUnmatched = 0; // Counter for unmatched ')'
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftUnmatched++; // Found an unmatched '('
            } else if (c == ')') {
                if (leftUnmatched > 0) {
                    leftUnmatched--; // Match with an unmatched '('
                } else {
                    rightUnmatched++; // Found an unmatched ')'
                }
            }
        }
        
        // Total moves needed is the sum of unmatched '(' and unmatched ')'
        return leftUnmatched + rightUnmatched;
    }
}
