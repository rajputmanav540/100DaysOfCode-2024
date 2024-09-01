class Solution {
public:
    string getActual(string s) {
        int n = s.length();
        int hashCount = 0;
        string ans = "";

        for(int i=n-1; i>=0; i--) {
            if(s[i] == '#') {
                hashCount++;
                continue;
            }

            if (hashCount > 0) {
                hashCount--;
            }
            else {
                ans.push_back(s[i]);
            }
        }

        return ans;
    }

    bool backspaceCompare(string s, string t) {
        return ( getActual(s) == getActual(t) );
    }
};
