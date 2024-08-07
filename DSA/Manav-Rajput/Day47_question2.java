class Solution {
    int median(int matrix[][], int R, int C) {
       
        int arr[]=new int[R*C];
        int a=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                arr[a]=matrix[i][j];
                a++;
            }
        }
        Arrays.sort(arr);
        
        return arr[arr.length/2];
        
        
    }
}
