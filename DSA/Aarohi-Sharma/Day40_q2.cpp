class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.size();
        int i = 0, j = 0;
        while (j < n) {
            if (dominoes[j] == '.') {
                j++;
            } 
            else if (dominoes[j] == 'L') {
                if (dominoes[i] == 'R') {
                    int s = i, e = j;
                    while (s < e) {
                        dominoes[s++] = 'R';
                        dominoes[e--] = 'L';
                    }
                } 
                else {
                    for (int x = i; x <= j; x++)
                        dominoes[x] = 'L';
                }
                i = j + 1;
                j = j + 2;
            } 
            else {
                if (dominoes[i] == 'R') {
                    for (int x = i; x <= j; x++)
                        dominoes[x] = 'R';
                }
                i = j;
                j++;
            }
        }
        if (dominoes[i] == 'R') {
            for (int x = i; x < n; x++)
                dominoes[x] = 'R';
        }
        return dominoes;
    }
};
