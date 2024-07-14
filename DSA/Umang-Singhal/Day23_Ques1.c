#include <stdio.h>
#include <ctype.h>
#include <limits.h>
int myAtoi(char s[]);
int main() {
    char s[1000];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    int result = myAtoi(s);
    printf("Converted integer: %d\n", result);
    return 0;
}
int myAtoi(char s[]) {
    int i = 0, sign = 1, result = 0;
    while (isspace(s[i])) {
        i++;
    }
    if (s[i] == '-' || s[i] == '+') {
        sign = (s[i] == '-') ? -1 : 1;
        i++;
    }
    while (isdigit(s[i])) {
        int digit = s[i] - '0';
        if (result > (INT_MAX - digit) / 10) {
            return (sign == 1) ? INT_MAX : INT_MIN;
        }
        result = result * 10 + digit;
        i++;
    }
    return result * sign;
}
