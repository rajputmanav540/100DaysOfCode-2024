class Solution {
  public:
    string smallestNumber(int s, int d) {
        string ans = "";
        int i = 1;
        int num = 0;
        
        while(i <= d) {
            if(s-(d-i)*9 <= 0) {
                num = 0;
            }
            else {
                num = s-(d-i)*9;
            }
            
            if (num == 0 && i == 1) {
                num = 1;
            }
            
            if (num > 9) {
                return "-1";
            }
            
            ans += (num + '0');
            i++;
            s -= num;
        }
        
        return ans;
    }
};
