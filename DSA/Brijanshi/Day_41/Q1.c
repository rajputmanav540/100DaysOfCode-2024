#include <ctype.h>
#include <stdbool.h>
#include <string.h>
#include <stdio.h>

bool isPalindrome(char *s) {
    int left = 0, right = strlen(s) - 1;
    while (left < right) {
        while (left < right && !isalnum(s[left])) {
            left++;
        }
        while (left < right && !isalnum(s[right])) {
            right--;
        }
        if (tolower(s[left]) != tolower(s[right])) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

int main() {
    char s[100001];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = 0; // remove newline character
    bool result = isPalindrome(s);
    if (result) {
        printf("The string is a palindrome.\n");
    } else {
        printf("The string is not a palindrome.\n");
    }
    return 0;
}
