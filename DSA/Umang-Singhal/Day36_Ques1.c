#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int findMaxNumber(int num) {
    char numStr[20];
    sprintf(numStr, "%d", num);
    int len = strlen(numStr);
    int maxNum = num;
    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
            char temp = numStr[i];
            numStr[i] = numStr[j];
            numStr[j] = temp;
            int swappedNum = atoi(numStr);
            if (swappedNum > maxNum) {
                maxNum = swappedNum;
            }
            temp = numStr[i];
            numStr[i] = numStr[j];
            numStr[j] = temp;
        }
    }
    return maxNum;
}
int main() {
    int num;
    printf("Enter an integer: ");
    scanf("%d", &num);
    int result = findMaxNumber(num);
    printf("Maximum valued number after at most one swap: %d\n", result);
    return 0;
}
