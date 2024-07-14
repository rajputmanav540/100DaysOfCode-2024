public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        int result = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > maxDiv10 || (result == maxDiv10 && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("42"));           
        System.out.println(solution.myAtoi("   -42"));       
        System.out.println(solution.myAtoi("1337c0d3"));     
        System.out.println(solution.myAtoi("0-1"));         
        System.out.println(solution.myAtoi("words and 987"));
    }
}
