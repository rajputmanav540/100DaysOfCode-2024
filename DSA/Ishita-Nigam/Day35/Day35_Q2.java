import java.util.Scanner;

public class Day35_Q2 {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            int sum_1 = i * (i + 1) / 2;
            if (sum_1 > n)
                break;
            if ((n - sum_1) % i == 0)
                count++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        Day35_Q2 solution = new Day35_Q2();
        System.out.println("Number of ways to write " + n + " as a sum of consecutive numbers: " + solution.consecutiveNumbersSum(n));
    }
}
