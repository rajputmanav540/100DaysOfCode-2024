#include <stdio.h>
void generatePascalsTriangle(int numRows) {
    int triangle[50][50] = {0}; 
    triangle[0][0] = 1;
    for (int i = 1; i < numRows; i++) {
        triangle[i][0] = 1;
        for (int j = 1; j <= i; j++) {
            triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
        }
    }
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j <= i; j++) {
            printf("%d ", triangle[i][j]);
        }
        printf("\n");
    }
}
int main() {
    int numRows;
    printf("Enter the number of rows: ");
    scanf("%d", &numRows);
    generatePascalsTriangle(numRows);
    return 0;
}
