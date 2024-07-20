#include <stdio.h>
int findMajorityElement(int nums[], int n) {
    int count = 0;
    int candidate = 0;
    for (int i = 0; i < n; i++) {
        if (count == 0) {
            candidate = nums[i];
        }
        if (nums[i] == candidate) {
            count++;
        } else {
            count--;
        }
    }
    return candidate;
}
int main() {
    int n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int nums[n];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }
    int majorityElement = findMajorityElement(nums, n);
    printf("The majority element is: %d\n", majorityElement);
    return 0;
}
