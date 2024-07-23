#include <stdio.h>
int dominantIndex(int nums[], int n) {
    if (n == 0) return -1;
    int maxIndex = 0;
    for (int i = 1; i < n; i++) {
        if (nums[i] > nums[maxIndex]) {
            maxIndex = i;
        }
    }
    for (int i = 0; i < n; i++) {
        if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
            return -1;
        }
    }
    return maxIndex;
}
int main() {
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    if (n == 0) {
        printf("Array must have at least 1 element.\n");
        return 1;
    }
    int nums[n];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    int result = dominantIndex(nums, n);
    printf("The result is: %d\n", result);
    return 0;
}
