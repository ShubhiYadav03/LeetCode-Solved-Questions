class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        minCost(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }
    
    int minCost(int[] cost, int idx, int[] dp){
        if(idx >= cost.length) return 0;
        
        if(dp[idx] != -1) return dp[idx];
      
         
        return dp[idx] = cost[idx] + Math.min(minCost(cost, idx + 1, dp), minCost(cost, idx + 2, dp));
        
    }
    
}