#include <stdio.h>
int minRotations(int tops[], int bottoms[], int n, int target) {
    int topRotations = 0;
    int bottomRotations = 0;
    for (int i = 0; i < n; i++) {
        if (tops[i] != target && bottoms[i] != target) {
            return -1;
        } else if (tops[i] != target) {
            topRotations++;
        } else if (bottoms[i] != target) {
            bottomRotations++;
        }
    }
    return topRotations < bottomRotations ? topRotations : bottomRotations;
}
int minDominoRotations(int tops[], int bottoms[], int n) {
    int rotations = minRotations(tops, bottoms, n, tops[0]);    
    if (rotations != -1 || tops[0] == bottoms[0]) {
        return rotations;
    } else {
        return minRotations(tops, bottoms, n, bottoms[0]);
    }
}
int main() {
    int n;
    printf("Enter the number of dominoes: ");
    scanf("%d", &n);
    int tops[n], bottoms[n];
    printf("Enter the top values of the dominoes: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &tops[i]);
    }
    printf("Enter the bottom values of the dominoes: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &bottoms[i]);
    }
    int result = minDominoRotations(tops, bottoms, n);
    if (result == -1) {
        printf("It is not possible to make all values the same.\n");
    } else {
        printf("The minimum number of rotations needed: %d\n", result);
    }
    return 0;
}
