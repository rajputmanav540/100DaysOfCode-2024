
//Fibonacci Number
import java.util.Scanner;

public class Day35_Q1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        Day35_Q1 solution = new Day35_Q1();
        System.out.println("Fibonacci of " + n + " is: " + solution.fib(n));
    }
}
