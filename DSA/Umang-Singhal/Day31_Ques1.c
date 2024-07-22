#include <stdio.h>
void productExceptSelf(int nums[], int size, int answer[]) {
    int left[size];
    int right[size];
    left[0] = 1;
    right[size - 1] = 1;
    for (int i = 1; i < size; i++) {
        left[i] = nums[i - 1] * left[i - 1];
    }
    for (int i = size - 2; i >= 0; i--) {
        right[i] = nums[i + 1] * right[i + 1];
    }
    for (int i = 0; i < size; i++) {
        answer[i] = left[i] * right[i];
    }
}
int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    int nums[size];
    int answer[size];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }
    productExceptSelf(nums, size, answer);
    printf("The product array is: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", answer[i]);
    }
    printf("\n");
    return 0;
}
