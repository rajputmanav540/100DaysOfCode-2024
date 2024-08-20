#include <stdio.h>

bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target) {
    int row = matrixSize;
    int col = matrixColSize[0];

    int s = 0;
    int e = (row * col) - 1;
    int mid = s + (e - s) / 2;

    while (s <= e) {
        int element = matrix[mid / col][mid % col];

        if (target == element) {
            return 1;
        }

        else if (target > element) {
            s = mid + 1;
        }

        else {
            e = mid - 1;
        }

        mid = s + (e - s) / 2;
    }

    return 0;
}

int main() {
    int matrix[][4] = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };

    int matrixSize = 3;
    int matrixColSize[] = {4};

    int target = 3;

    printf("%d\n", searchMatrix((int**)matrix, matrixSize, matrixColSize, target));

    return 0;
}
