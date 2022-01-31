class Solution {
    public int maximumWealth(int[][] accounts) {
        int t=0,w=0,r=0;
        
        for(int i=0;i<accounts.length;i++){
            w=0;
            for(int j=0;j<accounts[i].length;j++){
            w=w+accounts[i][j];
            
        }
             t=w;   
            if(t>r){
                r=t;
            }
        }
        return r;
    }
}