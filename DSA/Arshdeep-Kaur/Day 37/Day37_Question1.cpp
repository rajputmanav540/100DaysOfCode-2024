class Solution{
  public:
    int dp[1001][1001];
    int rec(int i, int j, string &s1, string &s2) {
        if (i == s1.size() || j == s2.size()) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s1[i] == s2[j]) {
            return dp[i][j] = 1+rec(i+1, j+1, s1, s2);
        }
        
        int choice1 = rec(i+1, j, s1, s2);
        int choice2 = rec(i, j+1, s1, s2);
        return dp[i][j] = max(choice1, choice2);
    }
    
    int countMin(string str) {
        string str2 = str;
        reverse(str2.begin(), str2.end());
        memset(dp, -1, sizeof(dp));
        int lcs = rec(0, 0, str, str2);
        
        return (str.size() - lcs);
    }
};
