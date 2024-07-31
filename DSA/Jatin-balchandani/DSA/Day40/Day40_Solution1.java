public class Day40_Solution1 {
    // Function for finding the minimum number of swaps to bring elements <= K together
    public static int minSwap(int arr[], int n, int k) {
        // Step 1: Count the number of elements <= k
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }

        // If no elements are <= k, no swaps are needed
        if (count == 0) return 0;

        // Step 2: Find the number of elements > k in the first 'count' elements
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        // Step 3: Initialize the minimum swaps as the initial 'bad' count
        int minSwaps = bad;

        // Step 4: Slide the window across the array
        for (int i = 0, j = count; j < n; i++, j++) {
            // Remove the influence of the element leaving the window
            if (arr[i] > k) {
                bad--;
            }

            // Add the influence of the new element entering the window
            if (arr[j] > k) {
                bad++;
            }

            // Update the minimum swaps
            minSwaps = Math.min(minSwaps, bad);
        }

        return minSwaps;
    }
}