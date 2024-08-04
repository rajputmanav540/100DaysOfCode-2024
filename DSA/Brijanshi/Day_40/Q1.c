#include <stdio.h>

int minSwap(int arr[], int n, int k) {
    int cnt = 0, ans = n;
    for (int i = 0; i < n; i++) {
        if (arr[i] <= k) cnt++;
    }
    int bad = 0;
    for (int i = 0; i < cnt; i++) {
        if (arr[i] > k) bad++;
    }
    ans = bad;
    for (int i = 0, j = cnt; j < n; i++, j++) {
        if (arr[i] > k) bad--;
        if (arr[j] > k) bad++;
        ans = (ans < bad) ? ans : bad;
    }
    return ans;
}

int main() {
    int n, k;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    printf("Enter the value of k: ");
    scanf("%d", &k);
    int result = minSwap(arr, n, k);
    printf("The minimum number of swaps required is: %d\n", result);
    return 0;
}
