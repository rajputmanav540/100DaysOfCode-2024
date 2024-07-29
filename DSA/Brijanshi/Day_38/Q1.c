#include <stdio.h>

void removeDuplicates(char* str) {
    int i = 0, j = 1;
    while (str[j] != '\0') {
        if (str[i] != str[j]) {
            i++;
            str[i] = str[j];
        }
        j++;
    }
    str[i + 1] = '\0';
}

int main() {
    char str[100001];
    printf("Enter a string: ");
    scanf("%s", str);
    removeDuplicates(str);
    printf("String after removing duplicates: %s\n", str);
    return 0;
}
