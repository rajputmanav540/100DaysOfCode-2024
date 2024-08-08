#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int getMinDiff(int arr[], int n, int k) {

    qsort(arr, n, sizeof(int), compare);

    int ans = arr[n-1] - arr[0];

    int small = arr[0] + k;
    int big = arr[n-1] - k;

    ans = (ans > big - small) ? big - small : ans;

    for (int i = 0; i < n-1; i++) {
        small = (arr[i+1] - k > small) ? small : arr[i+1] - k;
        big = (arr[i] + k < big) ? big : arr[i] + k;
        ans = (ans > big - small) ? big - small : ans;
    }

    return ans;
}

int main() {
    int k = 2;
    int n = 4;
    int arr[] = {1, 5, 8, 10};

    printf("Original array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int min_diff = getMinDiff(arr, n, k);
    printf("Minimum difference is %d\n", min_diff);

    return 0;
}
