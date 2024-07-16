#include <stdio.h>
#include <stdlib.h>

int* summ(int* nums, int numsSize, int no, int* returnSize) {
    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == no) {
                int* result = (int*)malloc(2 * sizeof(int));
                result[0] = i;
                result[1] = j;
                *returnSize = 2;
                return result;
            }
        }
    }
    *returnSize = 0;
    return NULL;
}

int main() {
    int nums1[] = {2, 7, 11, 15};
    int no = 9;
    int returnSize1;
    int* rel = summ(nums1, 4, no, &returnSize1);
    if (returnSize1 == 2) {
        printf("Output: [%d, %d]\n", rel[0], rel[1]);
        free(rel);
    }


    

    return 0;
}
