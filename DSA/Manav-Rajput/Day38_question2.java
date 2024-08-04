class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxRowIndex = -1;  
        int maxCount = 0;      
        int rowCount = arr.length;    
        int colCount = arr[0].length; 
        int row = 0, col = colCount - 1;

        while (row < rowCount && col >= 0) {
            if (arr[row][col] == 1) {
                maxRowIndex = row;
                maxCount = colCount - col;
                col--;
            } 
            else {
                row++;
            }
        }

        return maxRowIndex;
    }
}
