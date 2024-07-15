#include <stdio.h>
void inputArray(int nums[], int size) {
    printf("Enter %d elements:\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }
}
void rotateArray(int nums[], int size, int k) {
    k = k % size;
    int rotated[size];
    for (int i = 0; i < size; i++) {
        rotated[(i + k) % size] = nums[i];
    }
    for (int i = 0; i < size; i++) {
        nums[i] = rotated[i];
    }
}
void printArray(int nums[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}
int main() {
    int size, k;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    int nums[size];
    inputArray(nums, size);
    printf("Enter the number of steps to rotate the array: ");
    scanf("%d", &k);
    rotateArray(nums, size, k);
    printf("The rotated array is:\n");
    printArray(nums, size);
    return 0;
}
