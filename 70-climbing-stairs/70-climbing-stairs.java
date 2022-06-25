class Solution {
    
    public int climbStairs(int n) {
        if(n<4) return n;
        
        int curr=0,prev1=2,prev2=3;
        for(int i=4;i<=n;i++){
            curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return curr;
    }
}