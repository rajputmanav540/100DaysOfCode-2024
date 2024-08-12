class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxRowIndex = -1;
        int max1sCount = 0;
        int n = arr.length;
        int m = arr[0].length;
        
        for (int i = 0; i < n; i++) {
            int count1s = count1sInRow(arr[i], m);
            if (count1s > max1sCount) {
                max1sCount = count1s;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    private int count1sInRow(int[] row, int m) {
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return m - left; 
    }
}
