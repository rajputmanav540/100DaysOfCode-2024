
class Complete {
    public static int minSwap(int[] arr, int n, int k) {
        int countLessOrEqualK = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                countLessOrEqualK++;
            }
        }
        int unwanted = 0;
        for (int i = 0; i < countLessOrEqualK; i++) {
            if (arr[i] > k) {
                unwanted++;
            }
        }
        int minSwaps = unwanted;
        for (int i = 0, j = countLessOrEqualK; j < n; i++, j++) {
          
            if (arr[i] > k) {
                unwanted--;
            }
           
            if (arr[j] > k) {
                unwanted++;
            }
            minSwaps = Math.min(minSwaps, unwanted);
        }
        
        return minSwaps;
    }
}
