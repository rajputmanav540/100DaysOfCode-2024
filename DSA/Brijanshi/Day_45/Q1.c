#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isLongPressedName(char * name, char * typed) {
    int i = 0, j = 0;
    while (j < strlen(typed)) {
        if (i < strlen(name) && name[i] == typed[j]) {
            i++;
            j++;
        } else if (j > 0 && typed[j] == typed[j-1]) {
            j++;
        } else {
            return false;
        }
    }
    return i == strlen(name);
}

int main() {
    char *name1 = "alex";
    char *typed1 = "aaleex";
    printf("Test case 1: %s, %s\n", name1, typed1);
    printf("Result: %d\n", isLongPressedName(name1, typed1)); // Output: 1 (true)

    char *name2 = "saeed";
    char *typed2 = "ssaaedd";
    printf("\nTest case 2: %s, %s\n", name2, typed2);
    printf("Result: %d\n", isLongPressedName(name2, typed2)); // Output: 0 (false)

    char *name3 = "pyplrzzzzdsfa";
    char *typed3 = "ppyyplrzzzzzzdsfa";
    printf("\nTest case 3: %s, %s\n", name3, typed3);
    printf("Result: %d\n", isLongPressedName(name3, typed3)); // Output: 1 (true)

    char *name4 = "xnhtq";
    char *typed4 = "xhhttqq";
    printf("\nTest case 4: %s, %s\n", name4, typed4);
    printf("Result: %d\n", isLongPressedName(name4, typed4)); // Output: 0 (false)

    return 0;
}
