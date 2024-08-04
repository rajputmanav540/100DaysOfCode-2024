#include <stdio.h>
#include <stdlib.h>

#define ll long long int

int cmp(const void *a, const void *b) {
    return (*(ll*)b - *(ll*)a);
}

int main(void) {
    int t;
    scanf("%d", &t);
    while(t--) {
        ll n, m, sum_1 = 0, sum_2 = 0, val;
        scanf("%lld %lld", &n, &m);
        ll cnt1 = n, cnt2 = m;
        ll a[n], b[m];
        
        for(int i = 0; i < n; i++) {
            scanf("%lld", &a[i]);
            sum_1 += a[i];
            if(a[i] == 0)
                cnt1--;
        }
        
        for(int j = 0; j < m; j++) {
            scanf("%lld", &b[j]);
            sum_2 += b[j];
            if(b[j] == 0)
                cnt2--;
        }
        
        qsort(a, n, sizeof(ll), cmp);
        qsort(b, m, sizeof(ll), cmp);
        
        n = cnt1;
        m = cnt2;
        
        if(n != m) {
            if(sum_1 == sum_2 && sum_1 == 0) {
                printf("Bob\n");
            } else {
                printf("Alice\n");
            }
        } else {
            if(sum_1 == sum_2) {
                int fl = 0;
                for(int i = 0; i < n; i++) {
                    if(a[i] != b[i]) {
                        fl = 1;
                        break;
                    }
                }
                if(fl)
                    printf("Alice\n");
                else
                    printf("Bob\n");
            } else {
                printf("Alice\n");
            }
        }
    }
    return 0;
}
