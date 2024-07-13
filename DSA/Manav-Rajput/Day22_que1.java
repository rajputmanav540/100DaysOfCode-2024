import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {

        if (x > y) {
            return calculatePoints(s, 'a', 'b', x, y);
        } else {
            return calculatePoints(s, 'b', 'a', y, x);
        }
    }
    
    private int calculatePoints(String s, char first, char second, int firstValue, int secondValue) {
        Stack<Character> stack = new Stack<>();
        int points = 0;
        
        // Remove all occurrences of the first pair
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                points += firstValue;
            } else {
                stack.push(c);
            }
        }
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && c == first) {
                stack.pop();
                points += secondValue;
            } else {
                stack.push(c);
            }
        }
        
        return points;
    }
     public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "cdbcbbaaabab";
        int x1 = 4;
        int y1 = 5;
        System.out.println("Maximum Gain: " + solution.maximumGain(s1, x1, y1)); 
        String s2 = "aabbaaxybbaabb";
        int x2 = 5;
        int y2 = 4;
        System.out.println("Maximum Gain: " + solution.maximumGain(s2, x2, y2));
    }
}
