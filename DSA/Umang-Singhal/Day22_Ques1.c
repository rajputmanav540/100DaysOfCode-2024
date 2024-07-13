#include <stdio.h>
#include <string.h>

int maxPoints(char *s, int x, int y) {
    int points = 0;
    int len = strlen(s);
    char stack[len + 1];
    int top = -1;

    if (x > y) {
        for (int i = 0; i < len; i++) {
            if (top >= 0 && stack[top] == 'a' && s[i] == 'b') {
                top--;
                points += x;
            } else {
                stack[++top] = s[i];
            }
        }

        char reduced[len + 1];
        int reducedTop = -1;
        for (int i = 0; i <= top; i++) {
            if (reducedTop >= 0 && reduced[reducedTop] == 'b' && stack[i] == 'a') {
                reducedTop--;
                points += y;
            } else {
                reduced[++reducedTop] = stack[i];
            }
        }
    } else {
        for (int i = 0; i < len; i++) {
            if (top >= 0 && stack[top] == 'b' && s[i] == 'a') {
                top--;
                points += y;
            } else {
                stack[++top] = s[i];
            }
        }

        char reduced[len + 1];
        int reducedTop = -1;
        for (int i = 0; i <= top; i++) {
            if (reducedTop >= 0 && reduced[reducedTop] == 'a' && stack[i] == 'b') {
                reducedTop--;
                points += x;
            } else {
                reduced[++reducedTop] = stack[i];
            }
        }
    }

    return points;
}

int main() {
    char s[1001];
    int x, y;

    printf("Enter the string: ");
    scanf("%1000s", s);

    printf("Enter the value of x: ");
    scanf("%d", &x);

    printf("Enter the value of y: ");
    scanf("%d", &y);

    int result = maxPoints(s, x, y);
    printf("Maximum points: %d\n", result);

    return 0;
}
