class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        int n = nums.size();
        vector<int> arr(n + 1, 0);

        //calculate the prefix sums
        for(int i=0; i<n; i++){
            arr[i+1] = nums[i] + arr[i];
        }

        int sum=0;

        // First try: firstLen subarray comes before secondLen subarray
        for(int i=0; i<=n-firstLen-secondLen; i++){
            int firstsum = arr[i+firstLen] - arr[i];
            for(int j=i+firstLen; j<=n-secondLen; j++){
                int secondsum = arr[j+secondLen] - arr[j];
                sum = max(sum,firstsum+secondsum);
            }
        }

        // Second try: secondLen subarray comes before firstLen subarray
        for(int i=0; i<=n-firstLen-secondLen; i++){
            int secondsum = arr[i+secondLen] - arr[i];
            for(int j=i+secondLen; j<=n-firstLen; j++){
                int firstsum = arr[j+firstLen] - arr[j];
                sum = max(sum,firstsum+secondsum);
            }
        }
        
        return sum;
    }
};
