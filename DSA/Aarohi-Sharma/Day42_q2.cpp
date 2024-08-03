class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int n = seats.size();
        int maxi = 1, equalDis = 1;
        for(int i=0; i<n; i++){
            if(seats[i] == 0){
                int left = i-1, leftCount = 0;
                while(left > 0){
                    if(seats[left] == 0){
                        left--;
                    }
                    else{
                        break;
                    }
                }
                leftCount = i-left;
                int right = i+1, rightCount = 0;
                while(right < n){
                    if(seats[right] == 0){
                        right++;
                    }
                    else{
                        break;
                    }
                }
                rightCount = right - i;
                if(right >= n){
                    rightCount = leftCount;
                }
                if(left < 0){
                    leftCount = rightCount;
                }
                if(leftCount == rightCount){
                    equalDis = rightCount;
                }
                if(leftCount < rightCount){
                    maxi = max(maxi, leftCount);
                }
                if(rightCount < leftCount){
                    maxi = max(maxi, rightCount);
                }
                maxi = max(equalDis, maxi);
            }
        }
        return maxi;
    }
};
