#include <stdio.h>

void productExceptSelf(int* nums, int numsSize, int* answer) {
    int left = 1;
    for (int i = 0; i < numsSize; i++) {
        answer[i] = left;
        left *= nums[i];
    }

    int right = 1;
    for (int i = numsSize - 1; i >= 0; i--) {
        answer[i] *= right;
        right *= nums[i];
    }
}

int main() {
    int nums1[] = {1,2,3,4};
    int nums2[] = {-1,1,0,-3,3};

    int nums1Size = sizeof(nums1) / sizeof(nums1[0]);
    int nums2Size = sizeof(nums2) / sizeof(nums2[0]);

    int answer1[nums1Size];
    int answer2[nums2Size];

    productExceptSelf(nums1, nums1Size, answer1);
    productExceptSelf(nums2, nums2Size, answer2);

    printf("Product except self for nums1: ");
    for (int i = 0; i < nums1Size; i++) {
        printf("%d ", answer1[i]);
    }
    printf("\n");

    printf("Product except self for nums2: ");
    for (int i = 0; i < nums2Size; i++) {
        printf("%d ", answer2[i]);
    }
    printf("\n");

    return 0;
}
