// Remove Duplicate Letters

import java.util.Stack;

class Day64_Q1 {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i; // track the last index of character presence
        }

        boolean[] seen = new boolean[26]; // keep track of seen characters
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue; // if seen, skip as we only need one of each char
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]) {
                seen[st.pop()] = false; // pop out and mark unseen
            }
            st.push(curr); // add current char to stack
            seen[curr] = true; // mark as seen
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append((char) (st.pop() + 'a'));
        }
        return sb.reverse().toString(); // reverse to form correct order
    }

    // Main method to test the program
    public static void main(String[] args) {
        Day64_Q1 solution = new Day64_Q1();
        String input = "bcabc";
        String result = solution.removeDuplicateLetters(input);
        System.out.println("Result: " + result); // Expected output: "abc"
    }
}
