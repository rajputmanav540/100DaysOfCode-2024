//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    string removeDups(string str) {
        vector<bool> v(26,0);
        int i=0;
        while(i<str.length())
        {
            if(v[str[i]-'a']!=0)
            {
                str.erase(i,1);
            }
            else
            {
                v[str[i]-'a']=1;
                i++;
            }
        }
        return str;
    }
};

//{ Driver Code Starts.

int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;

        Solution ob;
        cout << ob.removeDups(s) << "\n";
    }

    return 0;
}
// } Driver Code Ends
