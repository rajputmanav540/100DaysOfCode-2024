class Solution {
    public boolean isPalindrome(int x) {
        int n=x;
        int c=0;
        if(x>=0)
        {
            while(n!=0)
            {
                int digit=n%10;
                c=c*10+digit;
                n=n/10;
            }
            if(c==x)
            {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
