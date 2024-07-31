
//Minimum swaps and K together
import java.util.Scanner;

public class Day40_Q1 {
    public static int minSwap(int arr[], int n, int k) {
        int snowBallSize = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                snowBallSize++;
            }
        }

        int swap = 0, ans_swaps = Integer.MAX_VALUE;

        for (int i = 0; i < snowBallSize; i++) {
            if (arr[i] > k)
                swap++;
        }

        ans_swaps = Math.min(ans_swaps, swap);

        for (int i = snowBallSize; i < n; i++) {
            if (arr[i - snowBallSize] <= k && arr[i] > k)
                swap++;
            else if (arr[i - snowBallSize] > k && arr[i] <= k)
                swap--;
            ans_swaps = Math.min(ans_swaps, swap);
        }
        return ans_swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();

        int result = minSwap(arr, n, k);
        System.out.println("Minimum number of swaps required: " + result);
    }
}
