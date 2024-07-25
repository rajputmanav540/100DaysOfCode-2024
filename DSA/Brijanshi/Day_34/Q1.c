#include <stdio.h>

void sort_array_by_parity(int* nums, int numsSize) {
    int* even_ptr = nums;
    int* odd_ptr = nums;

    while (odd_ptr < nums + numsSize) {
        if (*odd_ptr % 2 == 0) {
            // Swap even_ptr and odd_ptr
            int temp = *even_ptr;
            *even_ptr = *odd_ptr;
            *odd_ptr = temp;
            even_ptr++;
        }
        odd_ptr++;
    }
}

void print_array(int* nums, int numsSize) {
    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

int main() {
    int nums[] = {3, 1, 2, 4};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    printf("Original array: ");
    print_array(nums, numsSize);

    sort_array_by_parity(nums, numsSize);

    printf("Sorted array: ");
    print_array(nums, numsSize);

    return 0;
}
