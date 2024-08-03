public int sumSubseqWidths(int[] nums) {
       long twoPower [] =new long[nums.length];
       long mod = 1000000007L;
       twoPower[0] =1;
       for (int i = 1; i< nums.length; i++){
           twoPower[i] = (twoPower[i-1]*2)%mod;
       }
       long effective[] = new long[nums.length];
       for (int i = 0; i< nums.length; i++) {
    	   effective[i] = (twoPower[i]- twoPower[nums.length- i-1]);
       }
       Arrays.sort(nums);
       long ans = 0;
       for (int i = 0; i< nums.length; i++) {
    	   ans = (ans+ effective[i]*nums[i])%mod;
       }
       return (int) ans;
   }
