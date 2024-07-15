#include <stdio.h>
#include <stdlib.h>

int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    int left = 0, right = numsSize - 1;

    for (int i = numsSize - 1; i >= 0; i--) {
        if (abs(nums[left]) < abs(nums[right])) {
            result[i] = nums[right] * nums[right];
            right--;
        } else {
            result[i] = nums[left] * nums[left];
            left++;
        }
    }

    *returnSize = numsSize;
    return result;
}

int main() {
    int nums[] = {-4, -1, 0, 3, 10};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int returnSize;

    int* result = sortedSquares(nums, numsSize, &returnSize);

    printf("Sorted squares: ");
    for (int i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    free(result);

    return 0;
}
