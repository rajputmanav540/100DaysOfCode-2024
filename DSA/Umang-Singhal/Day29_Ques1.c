#include <stdio.h>
int maxChunksToSorted(int arr[], int n) {
    int chunks = 0;
    int max_so_far = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] > max_so_far) {
            max_so_far = arr[i];
        }
        if (max_so_far == i) {
            chunks++;
        }
    }   
    return chunks;
}
int main() {
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements of the array (permutation of integers from 0 to %d):\n", n - 1);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    int result = maxChunksToSorted(arr, n);
    printf("The largest number of chunks is: %d\n", result);
    return 0;
}
