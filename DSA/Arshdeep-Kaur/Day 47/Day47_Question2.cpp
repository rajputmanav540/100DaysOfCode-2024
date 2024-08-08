class Solution{   
public:
    int median(vector<vector<int>> &A, int row, int column){
        int low = 1, high = 1000000000;
        
        for(int i=0; i<row; i++) {
            low = min(low, A[i][0]);
            high = max(high, A[i][column-1]);
            
            int median = low;
            int medianPosition = (row*column + 1)/2;
            
            while(low <= high) {
                int mid = low + (high-low)/2;
                int count = 0;
                
                for(int i=0; i<row; i++) {
                    int index = upper_bound(A[i].begin(), A[i].end(), mid) - A[i].begin();
                    count += ((index-1)-0) + 1;
                }
                
                if(count < medianPosition) {
                    low = mid+1;
                    median = low;
                }
                else {
                    high = mid - 1;
                }
            }
            return median;
        }
    }
};
