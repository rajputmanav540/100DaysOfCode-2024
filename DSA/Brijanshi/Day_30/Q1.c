#include <stdio.h>

int maximumProduct(int* nums, int numsSize) {
    int max1 = nums[0], max2 = nums[0], max3 = nums[0];
    int min1 = nums[0], min2 = nums[0];

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] > max1) {
            max3 = max2;
            max2 = max1;
            max1 = nums[i];
        } else if (nums[i] > max2) {
            max3 = max2;
            max2 = nums[i];
        } else if (nums[i] > max3) {
            max3 = nums[i];
        }

        if (nums[i] < min1) {
            min2 = min1;
            min1 = nums[i];
        } else if (nums[i] < min2) {
            min2 = nums[i];
        }
    }

    return max1 * max2 * max3 > max1 * min1 * min2 ? max1 * max2 * max3 : max1 * min1 * min2;
}

int main() {
    int nums1[] = {1,2,3};
    int nums2[] = {1,2,3,4};
    int nums3[] = {-1,-2,-3};

    int nums1Size = sizeof(nums1) / sizeof(nums1[0]);
    int nums2Size = sizeof(nums2) / sizeof(nums2[0]);
    int nums3Size = sizeof(nums3) / sizeof(nums3[0]);

    int maxProduct1 = maximumProduct(nums1, nums1Size);
    int maxProduct2 = maximumProduct(nums2, nums2Size);
    int maxProduct3 = maximumProduct(nums3, nums3Size);

    printf("Maximum product of nums1: %d\n", maxProduct1);
    printf("Maximum product of nums2: %d\n", maxProduct2);
    printf("Maximum product of nums3: %d\n", maxProduct3);

    return 0;
}
