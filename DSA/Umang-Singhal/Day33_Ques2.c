#include <stdio.h>
#include <string.h>
void findSmallestNumber(int s, int d, char result[]) {
    if (s > 9 * d) {
        strcpy(result, "-1");
        return;
    }
    int digits[d];
    for (int i = 0; i < d; i++) {
        digits[i] = 0;
    }
    s -= 1;
    for (int i = d - 1; i >= 0; i--) {
        if (s > 9) {
            digits[i] = 9;
            s -= 9;
        } else {
            digits[i] = s;
            s = 0;
        }
    }
    digits[0] += 1;
    for (int i = 0; i < d; i++) {
        result[i] = digits[i] + '0';
    }
    result[d] = '\0'; 
}
int main() {
    int s, d;
    char result[101]; 
    printf("Enter the sum of digits (s): ");
    scanf("%d", &s);
    printf("Enter the number of digits (d): ");
    scanf("%d", &d);
    findSmallestNumber(s, d, result);
    printf("Resulting number: %s\n", result);
    return 0;
}
