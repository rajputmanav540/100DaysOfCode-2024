class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<tops.length;i++){
            if(tops[i]==bottoms[i]){
                hm.put(tops[i],(hm.getOrDefault(tops[i],0)+1));
            }
            else{
                hm.put(tops[i],(hm.getOrDefault(tops[i],0)+1));
                hm.put(bottoms[i],(hm.getOrDefault(bottoms[i],0)+1));
            }
        }
        int el=0;
        boolean flag=false;
        for(int i:hm.keySet()){
            int a=hm.get(i);
            if(a==tops.length){
                el=i;
                flag=true;
                break;
            }
        }
        if(!flag) return -1;
        int ans1=0,ans2=0;
        for(int i=0; i<tops.length; i++){
            if(tops[i]!=el) ans1++;
        }
        for(int i=0; i<bottoms.length; i++){
            if(bottoms[i]!=el) ans2++;
        }
        return Math.min(ans1,ans2);
    }
}
