class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int idx = n-1;
        int i=0,j=n-1;

        while(i<=j){
            if(Math.abs(arr[i])>Math.abs(arr[j])){
                ans[idx--] = arr[i]*arr[i];
                i++;
            }else{
                ans[idx--] = arr[j]*arr[j];
                j--;
            }
        }
        return ans;
    }
}
