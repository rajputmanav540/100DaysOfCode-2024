class Solution {
public:
    bool kPangram(string str, int k) {
        int count[26] = {0};
        int n = str.length();
        
        for (int i = 0; i < n; i++) {
            if (str[i] >= 'a' && str[i] <= 'z') {
                count[str[i] - 'a']++;
            } else if (str[i] >= 'A' && str[i] <= 'Z') {
                count[str[i] - 'A']++;
            }
        }
        
        int missingLetters = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                missingLetters++;
            }
        }
        
        return missingLetters <= k;
    }
};
