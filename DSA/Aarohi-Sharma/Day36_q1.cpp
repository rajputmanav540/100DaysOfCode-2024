class Solution {
public:
    int maximumSwap(int num) {
        int m=num;
        vector<int> a;
        int rem=0;
        while(num!=0){
            rem=num%10;
            a.push_back(rem);
            num=num/10;
        }
        reverse(a.begin(), a.end());
        if(a.size()==1){
            return m;
        }
        for(int i=0; i<a.size()-1; i+=2){
            if(a[i]<a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                break;
            }
        }
        int n=0;
        for(int i=0; i<a.size(); i++){
            n=n*10+a[i];
        }
        return n;
    }
};
