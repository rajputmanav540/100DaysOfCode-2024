class Solution {
public:
    int dp1[100001][8];
    int dp2[100001][8];
    int make_top_equal(int i, int last, vector<int>& tops, vector<int>& bottom){
        if(i==tops.size()) {
            return 0;
        }

        if(i>0 and tops[i]!=last and bottom[i]!=last) {
            return 1e9;
        }

        if(dp1[i][last+1] != -1) {
            return dp1[i][last+1];
        }

        int op1 = INT_MAX, op2 = INT_MAX;

        if(last == -1 || bottom[i] == last) {
            op1 = 1 + make_top_equal(i+1,bottom[i],tops,bottom);
        }
        
        if(last == -1 || tops[i] == last) {
            op2 = make_top_equal(i+1,tops[i],tops,bottom);
        } 
        
        return dp1[i][last+1] = min(op1,op2);
    }

    int make_bottom_equal(int i, int last, vector<int>& tops, vector<int>& bottom){
        if(i==tops.size()) {
            return 0;
        }
        
        if(i>0 and tops[i]!=last and bottom[i]!=last) {
            return 1e9;
        }

        if(dp2[i][last+1] != -1) {
            return dp2[i][last+1];
        }
        
        int op1 = INT_MAX, op2 = INT_MAX;
        
        if(last == -1 || tops[i] == last){
            op1 = 1 + make_bottom_equal(i+1,tops[i],tops,bottom);
        }
        
        if(last == -1 || bottom[i] == last) {
            op2 = make_bottom_equal(i+1,bottom[i],tops,bottom);
        }
        
        return dp2[i][last+1] = min(op1,op2);
    }

    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        memset(dp1,-1,sizeof(dp1));
        memset(dp2,-1,sizeof(dp2));
        int ans =  min(make_top_equal(0,-1,tops,bottoms), make_bottom_equal(0,-1,tops,bottoms));
        return (ans >= 1e9) ? -1: ans;
    }
};
