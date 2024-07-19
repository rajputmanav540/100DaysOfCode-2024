class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int srt=0,ans=0,n=arr.size();
        for(int i=0;i<n;i++){
            if(srt<arr[i])srt=arr[i];
            if(srt==i)ans++;
        }
        return ans;
    }
};
