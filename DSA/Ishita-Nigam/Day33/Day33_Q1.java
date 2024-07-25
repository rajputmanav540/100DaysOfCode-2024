class Day33_Q1 {
    public static class Solution {
        public String printString(String s, char ch, int count) {
            String str = "";
            int i = 0;
            while (i < s.length() && count != 0) {
                if (s.charAt(i) == ch) {
                    count--;
                }
                i++;
            }

            if (count == 0) {
                str = s.substring(i);
            }

            return str.equals("") ? "" : str;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.printString("abcde", 'c', 1)); 
        System.out.println(sol.printString("geeksforgeeks", 'e', 2)); 
        System.out.println(sol.printString("hello", 'l', 2)); 
        System.out.println(sol.printString("hello", 'z', 1)); 
    }
}
