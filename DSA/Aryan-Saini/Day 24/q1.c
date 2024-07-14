#include <stdio.h>
#include <stdlib.h>

int* squareAndSort(int* arr, int size, int* newSize) {
    int* result = (int*)malloc(size * sizeof(int));
    int left = 0, right = size - 1;
    int pos = size - 1;

    while (left <= right) {
        int leftSquare = arr[left] * arr[left];
        int rightSquare = arr[right] * arr[right];

        if (leftSquare > rightSquare) {
            result[pos] = leftSquare;
            left++;
        } else {
            result[pos] = rightSquare;
            right--;
        }

        pos--;
    }

    *newSize = size;
    return result;
}

int main() {
    int arr1[] = {-4, -1, 0, 3, 10};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    int newSize1;
    int* result1 = squareAndSort(arr1, size1, &newSize1);

    for (int i = 0; i < newSize1; i++) {
        printf("%d ", result1[i]);
    }
    printf("\n");

    free(result1);
    return 0;
}
