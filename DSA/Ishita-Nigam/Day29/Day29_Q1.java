//Max Chunks To Make Sorted
public class Day29_Q1 {
    public int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        int[] max = new int[arr.length];
        max[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            if(max[i] == i) {
                chunk++;
            }
        }
        return chunk;
    }

    public static void main(String[] args) {
        Day29_Q1 solution = new Day29_Q1();
        int[] arr = {4, 3, 2, 1, 0};
        int result = solution.maxChunksToSorted(arr);
        System.out.println("Maximum number of chunks: " + result);
    }
}
