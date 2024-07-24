class Solution {
    public String smallestNumber(int s, int d) {
        if(s<1 || s>d*9)
            return "-1";
        String str="";
        int sum=s;
        int i=1;
        while(i<=9){
            if(sum-i<=(d-1)*9){
                str+=i;
                d--;
                sum=sum-i;
                i=-1;
            }
            if(d==0)
                break;
            i++;
        }
        return str;
    }
}
