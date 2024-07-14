#include <limits.h>
#include <ctype.h>

int myAtoi(char *s) {
    int sign = 1;
    long long result = 0;
    int i = 0;

    // Ignore leading whitespace
    while (isspace(s[i])) {
        i++;
    }

    // Determine the sign
    if (s[i] == '-') {
        sign = -1;
        i++;
    } else if (s[i] == '+') {
        i++;
    }

    // Read the integer
    while (isdigit(s[i])) {
        result = result * 10 + (s[i++] - '0');
    }

    // Rounding
    result *= sign;
    if (result < INT_MIN) {
        return INT_MIN;
    } else if (result > INT_MAX) {
        return INT_MAX;
    }

    return (int)result;
}
