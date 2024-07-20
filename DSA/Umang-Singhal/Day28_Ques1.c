#include <stdio.h>
#include <string.h>
void longestCommonPrefix(char strs[][100], int n, char result[]) {
    if (n == 0) {
        result[0] = '\0';
        return;
    }
    strcpy(result, strs[0]);
    for (int i = 1; i < n; i++) {
        int j = 0;
        while (result[j] && strs[i][j] && result[j] == strs[i][j]) {
            j++;
        }
        result[j] = '\0'; 
        if (result[0] == '\0') {
            return;
        }
    }
}
int main() {
    int n;
    printf("Enter the number of strings: ");
    scanf("%d", &n);
    char strs[n][100];
    char result[100];
    printf("Enter the strings:\n");
    for (int i = 0; i < n; i++) {
        scanf("%s", strs[i]);
    }
    longestCommonPrefix(strs, n, result);
    if (result[0] == '\0') {
        printf("There is no common prefix.\n");
    } else {
        printf("The longest common prefix is: %s\n", result);
    }
    return 0;
}
