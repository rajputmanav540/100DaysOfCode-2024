#include <stdio.h>
void findElements(int nums[], int n) {
    int count1 = 0, count2 = 0;
    int candidate1 = 0, candidate2 = 1;
    for (int i = 0; i < n; i++) {
        if (nums[i] == candidate1) {
            count1++;
        } else if (nums[i] == candidate2) {
            count2++;
        } else if (count1 == 0) {
            candidate1 = nums[i];
            count1 = 1;
        } else if (count2 == 0) {
            candidate2 = nums[i];
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
    }
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] == candidate1) {
            count1++;
        } else if (nums[i] == candidate2) {
            count2++;
        }
    }
    printf("Elements that appear more than %d times are: ", n / 3);
    if (count1 > n / 3) {
        printf("%d ", candidate1);
    }
    if (count2 > n / 3) {
        printf("%d", candidate2);
    }
    printf("\n");
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
    findElements(nums, n);
    return 0;
}
