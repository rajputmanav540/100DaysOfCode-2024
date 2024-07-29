class Solution {
    public int rowWithMax1s(int arr[][]) {
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                if (arr[row][col] == 1) {
                    return row;
                }
            }
        }
        
        return -1;
    }
}
