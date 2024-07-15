#include <stdio.h>
void inputArray(int nums[], int size) {
    printf("Enter %d elements (sorted in non-decreasing order):\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &nums[i]);
    }
}
void squareArray(int nums[], int squares[], int size) {
    for (int i = 0; i < size; i++) {
        squares[i] = nums[i] * nums[i];
    }
}
void sortArray(int array[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
void printArray(int array[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}
int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    int nums[size];
    int squares[size];
    inputArray(nums, size);
    squareArray(nums, squares, size);
    sortArray(squares, size);
    printf("The sorted array of squares is:\n");
    printArray(squares, size);
    return 0;
}
