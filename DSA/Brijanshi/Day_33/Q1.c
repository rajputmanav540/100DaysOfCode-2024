#include <string.h>
#include <stdlib.h>

char* remainingSubstring(char* s, char ch, int count) {
    int occurrences = 0;
    int len = strlen(s);
    int i;

    for (i = 0; i < len; i++) {
        if (s[i] == ch) {
            occurrences++;
            if (occurrences == count) {
                char* result = (char*)malloc((len - i) * sizeof(char) + 1);
                strncpy(result, s + i + 1, len - i - 1);
                result[len - i] = '\0';
                return result;
            }
        }
    }

    char* result = (char*)malloc(1 * sizeof(char));
    result[0] = '\0';
    return result; // return an empty string if the character is not found or the count is not reached
}
