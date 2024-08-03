#include <stdio.h>

int firstMissingPositive(int* nums, int numsSize) {
    int i;
    for (i = 0; i < numsSize; i++) {
        while (nums[i] > 0 && nums[i] <= numsSize && nums[nums[i] - 1] != nums[i]) {
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
    }
    for (i = 0; i < numsSize; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return numsSize + 1;
}

int main() {
    int nums[100001];
    int numsSize;
    printf("Enter the size of the array: ");
    scanf("%d", &numsSize);
    printf("Enter the elements of the array: ");
    for (int i = 0; i < numsSize; i++) {
        scanf("%d", &nums[i]);
    }
    int result = firstMissingPositive(nums, numsSize);
    printf("The smallest positive integer that is not present in the array is: %d\n", result);
    return 0;
}
