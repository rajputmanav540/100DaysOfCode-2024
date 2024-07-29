class Solution {
    boolean kPangram(String str, int k) {
        int count[]=new int[26];
        int cnt=0;
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'a'<26 && str.charAt(i)-'a'>=0 ){
                count[str.charAt(i)-'a']=1;
                cnt++;
            }
        }
        
        int cntalpha=0;
        for(int i=0;i<26;i++){
            if(count[i]==1)cntalpha++;
        }
        
        int r=cnt-cntalpha;
        
      int needtochange=26-cntalpha;
      if(needtochange<=r) {
    	  if(needtochange<=k) {
    		  return true;
    	  }else return false;
      }else return false;
    }
}
