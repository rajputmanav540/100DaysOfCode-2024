#include <stdio.h>
int maximumProduct(int nums[], int n) {
    int max1 = -1001, max2 = -1001, max3 = -1001;
    int min1 = 1001, min2 = 1001;
    for (int i = 0; i < n; i++) {
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
    int product1 = max1 * max2 * max3;
    int product2 = min1 * min2 * max1;
    return product1 > product2 ? product1 : product2;
}
int main() {
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    if (n < 3) {
        printf("Array must have at least 3 elements.\n");
        return 1;
    }
    int nums[n];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    int result = maximumProduct(nums, n);
    printf("The maximum product of three numbers is: %d\n", result);
    return 0;
}
