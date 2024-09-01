class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> temp;
        int n = pushed.size();
        int i=0, j=0;

        while(i < n && j < n) {
            temp.push(pushed[i]);
            while(!temp.empty() && j<n && popped[j] == temp.top()) {
                temp.pop();
                j++;
            }
            i++;
        }

        return temp.empty();
    }
};
