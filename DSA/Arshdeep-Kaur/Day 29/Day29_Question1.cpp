class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int maximum = 0;
        int chunks = 0;

        for (int i=0; i<arr.size(); i++) {
            maximum = max(arr[i], maximum);
            if (i == maximum) {
                chunks++;
            }
        }

        return chunks;
    }
};
