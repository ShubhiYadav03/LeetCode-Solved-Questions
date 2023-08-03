class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
    
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int coinsUsed = solve(0, 0, coins, amount, dp);
        return (coinsUsed >= 0 && coinsUsed <= amount) ? coinsUsed : -1;
    }
    
    int solve(int idx, int sum, int[] coins, int amount, int dp[][]){
        int n = coins.length;
        if(idx == n - 1){
            if((amount - sum)% coins[idx] == 0) 
                return (amount - sum) / coins[idx];
            return amount + 1;
        }
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int pick = amount + 1;
        if(coins[idx] + sum <= amount){
            pick = solve(idx, sum + coins[idx], coins, amount, dp) + 1;
        }
        int notpick = solve(idx + 1, sum, coins, amount, dp);
        
        return dp[idx][sum] = Math.min(pick, notpick);
    }
}