class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
    
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
     
        return solve(0, 0, coins, amount, dp);
    }
    
    int solve(int idx, int sum, int[] coins, int amount, int dp[][]){
        int n = coins.length;
        if(idx == n && sum == amount){
            return 1;
        }
        if(idx == n) return 0;
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int pick = 0;
        if(coins[idx] + sum <= amount && sum + coins[idx] >= 0){
            pick = solve(idx, sum + coins[idx], coins, amount, dp);
        }
        int notpick = solve(idx + 1, sum, coins, amount, dp);
        
        return dp[idx][sum] = pick + notpick;
    }
}