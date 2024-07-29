class Solution{
    static int countMin(String str)
    {
       int n = str.length();
       String revStr = new StringBuilder(str).reverse().toString();
       
       int[][] dp = new int[n+1][n+1];
       
       for(int i = 1; i<=n; i++){
           for(int j = 1; j<=n; j++){
               if(i==0 || j==0){
                   dp[i][j] = 0;
               }
               else if(str.charAt(i-1)==revStr.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1] + 1;
               }
               else{
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
           }
       }
       
       int lcl = dp[n][n];
       
       return n - lcl;
    }
}
