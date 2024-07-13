#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void reverse(char* s, int start, int end) {
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
}

char* reversebrackets(char* s) {
    int n = strlen(s);
    int stack[n];
    int top = -1;
    int pairs[n];
    memset(pairs, -1, sizeof(pairs));
    
    for (int i = 0; i < n; i++) {
        if (s[i] == '(') {
            stack[++top] = i;
        } else if (s[i] == ')') {
            int start = stack[top--];
            pairs[start] = i;
            pairs[i] = start;
        }
    }
    char* result = (char*)malloc(n + 1);
    int index = 0;
    int i = 0;
    int direction = 1;
    
    while (i < n) {
        if (s[i] == '(' || s[i] == ')') {
            i = pairs[i];
            direction = -direction;
        } else {
            result[index++] = s[i];
        }
        i += direction;
    }
    result[index] = '\0';
    
    return result;
}

int main() {

    char statement[] = "(ed(et(oc))el)";

    printf("Example 3: %s\n", reversebrackets(statement)); 
    
    return 0;
}
