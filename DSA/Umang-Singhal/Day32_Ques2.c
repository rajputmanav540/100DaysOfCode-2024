#include <stdio.h>
#define MOD 1000000007
long long maxProductSubset(int arr[], int n) {
    if (n == 1)
        return arr[0];
    long long maxNeg = -1000000007;
    int countNeg = 0, countZero = 0;
    long long product = 1;
    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            countZero++;
            continue;
        }
        if (arr[i] < 0) {
            countNeg++;
            if (arr[i] > maxNeg)
                maxNeg = arr[i];
        }
        product = (product * arr[i]) % MOD;
    }
    if (countZero == n)
        return 0;
    if (countNeg % 2 != 0) {
        if (countNeg == 1 && countZero + countNeg == n)
            return 0;
        product = product / maxNeg;
    }
    return product;
}
int main() {
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    long long result = maxProductSubset(arr, n);
    printf("The maximum product of a subset is: %lld\n", result);
    return 0;
}
