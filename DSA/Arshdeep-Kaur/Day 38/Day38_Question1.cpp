class Solution {
  public:
    string removeDups(string str) {
        int count[26] = {0};
        int i = 0;
        
        while (i < str.length()) {
            if (count[str[i] - 'a'] == 0) {
                count[str[i] - 'a']++;
                i++;
            } else {
                str.erase(str.begin() + i);
            }
        }
        
        return str;
    }
};
