#include <stdio.h>

int maxChunksToSorted(int* arr, int arrSize) {
    int max_val = 0;
    int chunks = 0;
    for (int i = 0; i < arrSize; i++) {
        max_val = max_val > arr[i]? max_val : arr[i];
        if (max_val == i) {
            chunks++;
        }
    }
    return chunks;
}

int main() {
    int arr1[] = {4,3,2,1,0};
    int arr2[] = {1,0,2,3,4};

    int arr1Size = sizeof(arr1) / sizeof(arr1[0]);
    int arr2Size = sizeof(arr2) / sizeof(arr2[0]);

    int chunks1 = maxChunksToSorted(arr1, arr1Size);
    int chunks2 = maxChunksToSorted(arr2, arr2Size);

    printf("Largest number of chunks to sort arr1: %d\n", chunks1);
    printf("Largest number of chunks to sort arr2: %d\n", chunks2);

    return 0;
}
