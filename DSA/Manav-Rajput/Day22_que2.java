class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                current.reverse();
                StringBuilder temp = current;
                current = stack.pop();
                current.append(temp);
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "(abcd)";
        System.out.println("Output: " + solution.reverseParentheses(s1)); // Expected Output: "dcba"

        // Test case 2
        String s2 = "(u(love)i)";
        System.out.println("Output: " + solution.reverseParentheses(s2)); // Expected Output: "iloveu"

        // Test case 3
        String s3 = "(ed(et(oc))el)";
        System.out.println("Output: " + solution.reverseParentheses(s3)); // Expected Output: "leetcode"
    }
}
