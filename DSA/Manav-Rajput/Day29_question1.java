class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = 0; 
        int chunks = 0; 
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }
        
        return chunks;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] arr1 = {4, 3, 2, 1, 0};
        System.out.println("Max chunks for arr1: " + solution.maxChunksToSorted(arr1)); // Output: 1
        
        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println("Max chunks for arr2: " + solution.maxChunksToSorted(arr2)); // Output: 4
    }
}
