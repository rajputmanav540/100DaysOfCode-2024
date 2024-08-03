//Sum of Subsequence Widths
import java.util.Arrays;
import java.util.Scanner;

public class Day41_Q2 {
    int mod = (int) 1e9 + 7;
    long[] power;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        power = new long[len];
        initPower();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (ans + (nums[i] * effect(i, len)) % mod) % mod;
        }
        return (int) ans % mod;
    }

    private long effect(int curr, int len) {
        long plus = power[curr];
        long minus = power[len - curr - 1];
        return (plus - minus + mod) % mod;
    }

    private void initPower() {
        power[0] = 1;
        for (int i = 1; i < power.length; i++)
            power[i] = (2 * power[i - 1]) % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        Day41_Q2 solution = new Day41_Q2();
        int result = solution.sumSubseqWidths(nums);
        System.out.println("Sum of subsequence widths: " + result);
    }
}
