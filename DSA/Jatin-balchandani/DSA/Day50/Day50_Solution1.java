public class Day50_Solution1 {
        int ans = Integer.MAX_VALUE;

        public int daysRequired(int[] weights, int capacity){
            int days = 0,sum = 0;
            for(int i = 0;i<weights.length;i++){
                if(weights[i]>capacity) return -1;
                if(sum + weights[i] < capacity){
                    sum+=weights[i];
                }else if(sum+weights[i] == capacity){
                    sum = 0;
                    days++;
                }else{
                    days++;
                    sum=0;
                    sum+=weights[i];
                }

                if(i==weights.length-1 && sum<capacity && sum>0 ){
                    days++;
                }
            }

            return days;
        }

        public void solve(int start, int end, int[] weights, int days){

            int capacity = start + (( end-start)/2);
            int d = daysRequired(weights,capacity);
            if(d>days || d==-1 ){
                // System.out.println("If");
                if(capacity+1<=end)
                    solve(capacity+1,end,weights,days);
            }else {
                // System.out.println("ELSE");
                ans = Math.min(ans,capacity);
                if(start<=capacity-1)
                    solve(start,capacity-1, weights,days);
            }
            return ;
        }

        public int shipWithinDays(int[] weights, int days) {
            int sum = 0;
            for(int w: weights)
                sum+=w;
            // if(days==1)     return sum;
            ans = Integer.MAX_VALUE;
            int minDays = 1, maxDays = sum;
            solve(minDays, maxDays, weights, days);
            return ans;
        }
    }
