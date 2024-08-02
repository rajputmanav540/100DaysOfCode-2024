class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        // Sort the array from index l to r
        Arrays.sort(arr, l, r + 1);
        
        // Return the k-th smallest element
        return arr[l + k - 1];
    } 
}
