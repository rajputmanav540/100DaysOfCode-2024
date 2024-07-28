//Form a palindrome
import java.util.Arrays;
import java.util.Scanner;

public class Day37_Q1 {
    
    public static int solve(int start, int end, String str, int[][] dp) {
        if (start >= end) return dp[start][end] = 0;
        if (dp[start][end] != -1) return dp[start][end];
        if (str.charAt(start) == str.charAt(end)) {
            return dp[start][end] = solve(start + 1, end - 1, str, dp);
        }

        int addStart = solve(start + 1, end, str, dp);
        int addEnd = solve(start, end - 1, str, dp);

        return dp[start][end] = Math.min(addStart, addEnd) + 1;
    }
    
    public static int countMin(String str) {
        int N = str.length();
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        solve(0, N - 1, str, dp);
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();
        
        int result = countMin(str);
        System.out.println("Minimum number of insertions to form a palindrome: " + result);
    }
}
