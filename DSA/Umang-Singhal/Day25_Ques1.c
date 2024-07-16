#include <stdio.h>
int removeElement(int nums[], int length, int val) {
    int k = 0;
    for (int i = 0; i < length; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
int main() {
    int length, val;   
    printf("Enter the number of elements in the array: ");
    scanf("%d", &length);
    int nums[length];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < length; i++) {
        scanf("%d", &nums[i]);
    }
    printf("Enter the value to remove: ");
    scanf("%d", &val);
    int newLength = removeElement(nums, length, val);    
    printf("The new length of the array is: %d\n", newLength);
    printf("The array after removing %d is:\n", val);
    for (int i = 0; i < newLength; i++) {
        printf("%d ", nums[i]);
    }
    return 0;
}
