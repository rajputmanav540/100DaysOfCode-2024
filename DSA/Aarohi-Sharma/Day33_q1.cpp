class Solution {
  public:

    string printString(string s, char ch, int count) {
        int n=s.size();
        int i=0;
        int m=0;
        for(i=0; i<n; i++){
            if(s[i]==ch){
                m++;
            }
            if(m==count){
                break;
            }
        }
        if(m==0){
            return "";
        }
        string r=s.substr(i+1, n-i+1);
        return r;
    }
};
