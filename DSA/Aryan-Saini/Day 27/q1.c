#include <stdio.h>

int majorityElement(int* nums, int numsSize) {
    int majority = 0, count = 0;
    for (int i = 0; i < numsSize; i++) {
        if (count == 0) {
            majority = nums[i];
            count = 1;
        } else if (nums[i] == majority) {
            count++;
        } else {
            count--;
        }
    }
    return majority;
}

int main() {
    int nums2[] = {2, 2, 1, 1, 1, 2, 2};
    int size2 = sizeof(nums2) / sizeof(nums2[0]);

    printf("Majority element in nums2: %d\n", majorityElement(nums2, size2));

    return 0;
}
