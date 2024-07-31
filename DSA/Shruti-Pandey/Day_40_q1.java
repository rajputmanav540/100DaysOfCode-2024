class Complete{
    
    public static int minSwap (int arr[], int n, int k) {
      
        int fav = 0 ;
        int NonFav = 0;
        for(int i = 0 ; i<n ; i++){
            if(arr[i] <= k)fav++;
        }
        for(int j=0 ; j<fav ; j++){
            if(arr[j]>k)NonFav++;
        }
        int l = 0 ; int r = fav - 1; int result = Integer.MAX_VALUE;
        while(r<n){
            result = Math.min(result,NonFav);
            r++;
            if(r<n && arr[r]>k)NonFav++;
            if(l<n && arr[l]>k)NonFav--;
            l++;
            
        }
        
        return (result == Integer.MAX_VALUE)?0:result;
    }
    
    
}
