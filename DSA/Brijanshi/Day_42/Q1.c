#include <stdio.h>

int partition(int arr[], int l, int r) {
    int pivot = arr[r];
    int i = l - 1;
    for (int j = l; j < r; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[r];
    arr[r] = temp;
    return i + 1;
}

void quickSelect(int arr[], int l, int r, int k) {
    if (l == r) {
        return;
    }
    int pivotIndex = partition(arr, l, r);
    if (k == pivotIndex) {
        return;
    } else if (k < pivotIndex) {
        quickSelect(arr, l, pivotIndex - 1, k);
    } else {
        quickSelect(arr, pivotIndex + 1, r, k);
    }
}

int kthSmallest(int arr[], int l, int r, int k) {
    quickSelect(arr, l, r, k - 1);
    return arr[k - 1];
}

int main() {
    int arr[] = {7, 10, 4, 3, 20, 15};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 3;
    int result = kthSmallest(arr, 0, n - 1, k);
    printf("Kth smallest element is %d\n", result);
    return 0;
}
