#include <stdio.h>
int countSubarrays(int nums[], int size, int left, int right) {
    int count = 0;
    int start = 0, end = 0, validStart = 0;    
    while (end < size) {
        if (nums[end] >= left && nums[end] <= right) {
            validStart = end + 1;
        } else if (nums[end] > right) {
            start = end + 1;
            validStart = end + 1;
        }
        count += validStart - start;
        end++;
    }
    return count;
}
int main() {
    int size, left, right;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    int nums[size];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }
    printf("Enter the value of left: ");
    scanf("%d", &left);
    printf("Enter the value of right: ");
    scanf("%d", &right);
    int result = countSubarrays(nums, size, left, right);
    printf("The number of subarrays is: %d\n", result);
    return 0;
}
