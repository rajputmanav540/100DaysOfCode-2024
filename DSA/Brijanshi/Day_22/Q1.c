#include <stdio.h>
#include <string.h>

int removePairs(char *s, char *target, int *len) {
    int write_ind = 0, count = 0;
    for (int i = 0; i < *len; i++) {
        s[write_ind] = s[i];
        write_ind++;
        if (write_ind >= 2 && s[write_ind - 1] == target[1] && s[write_ind - 2] == target[0]) {
            count++;
            write_ind -= 2;
        }
    }
    *len = write_ind;
    return count;
}

int maximumGain(char *s, int x, int y) {
    int res = 0;
    char top[3], bot[3];
    int top_score, bot_score;

    if (y > x) {
        top[0] = 'b'; top[1] = 'a'; top[2] = '\0';
        top_score = y;
        bot[0] = 'a'; bot[1] = 'b'; bot[2] = '\0';
        bot_score = x;
    } else {
        top[0] = 'a'; top[1] = 'b'; top[2] = '\0';
        top_score = x;
        bot[0] = 'b'; bot[1] = 'a'; bot[2] = '\0';
        bot_score = y;
    }

    int len = strlen(s);
    res += removePairs(s, top, &len) * top_score;
    res += removePairs(s, bot, &len) * bot_score;
    return res;
}

int main() {
    char s[] = "ababab";
    int x = 5, y = 3;
    printf("maximumGain(\"%s\", %d, %d) = %d\n", s, x, y, maximumGain(s, x, y));
    return 0;
}
