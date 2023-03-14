class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        for(int i = cost.length - 1; i >= 0; i--){
            if(i <= cost.length - 3) dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
            else dp[i] = cost[i];
        }
        
        return Math.min(dp[0], dp[1]);
    }
}