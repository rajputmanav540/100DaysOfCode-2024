class Day34_Q2 {
    public static class Solution {
        public String smallestNumber(int s, int d) {
            if (d * 9 < s) return "-1";

            int n = (int)Math.pow(10, d - 1);
            int sum = s - 1;
            char[] temp = Integer.toString(n).toCharArray();

            int i = d - 1;
            while (i >= 0 && sum > 0) {
                if (sum > 9) {
                    temp[i] = '9';
                    sum -= 9;
                } else {
                    int val = temp[i] - '0';
                    val += sum;
                    temp[i] = (char)('0' + val);
                    sum = 0;
                }
                i--;
            }
            return new String(temp);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestNumber(9, 2));  
        System.out.println(sol.smallestNumber(20, 3)); 
        System.out.println(sol.smallestNumber(10, 2)); 
        System.out.println(sol.smallestNumber(1, 2));  
    }
}
