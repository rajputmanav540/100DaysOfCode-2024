// User function Template for C++
class Solution {
  public:
    string smallestNumber(int s, int d) {
        // code here
        int st=pow(10,d-1);
        int end=pow(10,d)-1;
        
        while(st <= end){
            
            int sum=0;
            int num=st;
            
            while(num>0){
                
                sum+=num%10;
                num/=10;
            }
            
            if(sum==s) return to_string(st);
            
            st++;
            
        }
        
        return "-1";
    }
};
