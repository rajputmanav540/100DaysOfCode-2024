class Solution {
public:
    int minAddToMakeValid(string s) {
        int res = 0, bal = 0;

        for(int i=0; i<s.length(); i++) {
            //an opening bracket
            if (s[i] == '(') {
                bal++;
            }
            //unbalanced closing brakcet 
            else if (bal <= 0) {
                res++;
            }
            //balanced closing bracket
            else {
                bal--;
            }
        }

        return res + bal;
    }
};
