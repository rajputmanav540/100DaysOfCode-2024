#include <stdbool.h>

bool isPalindrome(int x){
    if(x < 0) return false; // negative numbers are not palindromes
    
    int reversed = 0;
    int original = x;
    
    while(x!= 0) {
        int pop = x % 10;
        x /= 10;
        reversed = reversed * 10 + pop;
    }
    
    return original == reversed;
}

int main() {
    int x;
    printf("Enter a number: ");
    scanf("%d", &x);
    
    if(isPalindrome(x)) {
        printf("%d is a palindrome.\n", x);
    } else {
        printf("%d is not a palindrome.\n", x);
    }
    
    return 0;
}
