#include <stdio.h>
#include <string.h>

char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) return "";

    char* prefix = strs[0];
    for (int i = 1; i < strsSize; i++) {
        while (strncmp(prefix, strs[i], strlen(prefix))!= 0) {
            prefix = prefix + 1;
            if (*prefix == '\0') return "";
        }
    }
    return prefix;
}

int main() {
    char* strs[] = {"flower","flow","flight"};
    int strsSize = sizeof(strs) / sizeof(strs[0]);

    char* prefix = longestCommonPrefix(strs, strsSize);
    printf("Longest common prefix: %s\n", prefix);

    char* strs2[] = {"dog","racecar","car"};
    int strsSize2 = sizeof(strs2) / sizeof(strs2[0]);

    char* prefix2 = longestCommonPrefix(strs2, strsSize2);
    printf("Longest common prefix: %s\n", prefix2);

    return 0;
}
