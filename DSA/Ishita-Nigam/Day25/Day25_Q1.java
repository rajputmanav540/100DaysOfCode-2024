public class Day25_Q1 {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int idx = n - 1;
        int i = 0, j = n - 1;

        while (i <= j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                ans[idx--] = arr[i] * arr[i];
                i++;
            } else {
                ans[idx--] = arr[j] * arr[j];
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day25_Q1 solution = new Day25_Q1();
        int[] arr = {-4, -1, 0, 3, 10};
        int[] result = solution.sortedSquares(arr);
        System.out.println("Sorted squares: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
