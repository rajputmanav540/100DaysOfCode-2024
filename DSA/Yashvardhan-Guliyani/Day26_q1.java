class Solution {
    public boolean isPalindrome(int n) {
        int temp=n;    
        int sum=0;
  while(n>0){    
   int r=n%10; 
   sum=(sum*10)+r;    
   n=n/10;    
  }    
  if(temp == sum){
    return true;
  }   
  else{
    return false;
  }   
    }
}
