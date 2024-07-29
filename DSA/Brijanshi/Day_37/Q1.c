#include <stdio.h>
#include <string.h>

int minInsertions(char* str) {
    int n = strlen(str);
    int dp[n][n];

    for (int i = 0; i < n; i++) {
        dp[i][i] = 0;
    }

    for (int L = 2; L <= n; L++) {
        for (int i = 0; i < n - L + 1; i++) {
            int j = i + L - 1;
            if (str[i] == str[j] && L == 2) {
                dp[i][j] = 0;
            } else if (str[i] == str[j]) {
                dp[i][j] = dp[i + 1][j - 1];
            } else {
                dp[i][j] = 1 + min(dp[i][j - 1], dp[i + 1][j]);
            }
        }
    }

    return dp[0][n - 1];
}

int main() {
    char str[501];
    printf("Enter a string: ");
    scanf("%s", str);
    printf("Minimum number of characters to be inserted: %d\n", minInsertions(str));
    return 0;
}
