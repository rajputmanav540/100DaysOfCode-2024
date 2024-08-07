class Solution {
public:
    string orderlyQueue(string s, int k) {
        if (k > 1) {
            sort(s.begin(), s.end());
            return s;
        }

        string s_min = s;

        for(int i=0; i<s.length(); ++i) {
            s = s.substr(1) + s[0];
            s_min = min(s_min, s);
        }

        return s_min;
    }
};
