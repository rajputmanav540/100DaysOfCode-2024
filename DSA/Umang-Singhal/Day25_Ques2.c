#include <stdio.h>
void findTwoSum(int nums[], int length, int target) {
    for (int i = 0; i < length - 1; i++) {
        for (int j = i + 1; j < length; j++) {
            if (nums[i] + nums[j] == target) {
                printf("Indices: %d and %d\n", i, j);
                return;
            }
        }
    }
}
int main() {
    int length, target;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &length);    
    int nums[length];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < length; i++) {
        scanf("%d", &nums[i]);
    }
    printf("Enter the target value: ");
    scanf("%d", &target);
    findTwoSum(nums, length, target);
    return 0;
}
