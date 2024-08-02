#include <stdio.h>

int nimSum(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum ^= arr[i];
    }
    return sum;
}

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n, m;
        scanf("%d %d", &n, &m);
        int a[n], b[m];
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
        for (int i = 0; i < m; i++) {
            scanf("%d", &b[i]);
        }
        int aliceNimSum = nimSum(a, n);
        int bobNimSum = nimSum(b, m);
        if (aliceNimSum != bobNimSum) {
            printf("Alice\n");
        } else {
            printf("Bob\n");
        }
    }
    return 0;
}
