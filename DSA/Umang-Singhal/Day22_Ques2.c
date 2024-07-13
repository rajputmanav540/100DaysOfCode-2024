#include <stdio.h>
#include <string.h>

void reverseSegment(char *s, int start, int end) {
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
}

void processString(char *s) {
    int len = strlen(s);
    char stack[len];
    int stackIndex[len];
    int top = -1;

    for (int i = 0; i < len; i++) {
        if (s[i] == '(') {
            stack[++top] = '(';
            stackIndex[top] = i;
        } else if (s[i] == ')') {
            int start = stackIndex[top--];
            reverseSegment(s, start + 1, i - 1);
        }
    }

    int index = 0;
    for (int i = 0; i < len; i++) {
        if (s[i] != '(' && s[i] != ')') {
            s[index++] = s[i];
        }
    }
    s[index] = '\0';
}

int main() {
    char s[1001];

    printf("Enter the string: ");
    scanf("%1000s", s);

    processString(s);

    printf("Processed string: %s\n", s);

    return 0;
}
