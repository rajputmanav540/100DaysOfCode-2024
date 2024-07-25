#include <stdio.h>
#include <string.h>
void getRemainingSubstring(char s[], char ch, int count, char result[]) {
    int len = strlen(s);
    int chCount = 0;
    int i;
    for (i = 0; i < len; i++) {
        if (s[i] == ch) {
            chCount++;
            if (chCount == count) {
                break;
            }
        }
    }
    if (chCount < count || i == len - 1) {
        strcpy(result, "");
    } else {
        strcpy(result, s + i + 1);
    }
}
int main() {
    char s[100], ch, result[100];
    int count;
    printf("Enter the string (without spaces): ");
    scanf("%s", s);
    printf("Enter the character: ");
    scanf(" %c", &ch);
    printf("Enter the count: ");
    scanf("%d", &count);
    getRemainingSubstring(s, ch, count, result);
    printf("Resulting substring: \"%s\"\n", result);
    return 0;
}
