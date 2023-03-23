class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve(0, amount, 0, coins, dp);
        if(ans == Integer.MAX_VALUE || ans >= (int)Math.pow(10, 9)) return -1;
        return ans;
    }
    
    int solve(int idx, int amount, int sum, int[] coins, int[][] dp){
        int n = coins.length;
        
        if(idx == n - 1){
            if((amount - sum)% coins[idx] == 0) 
                return (amount - sum) / coins[idx];
            return Integer.MAX_VALUE;
        }
        
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int pick = (int)Math.pow(10, 9);
        if(amount >= sum + coins[idx]){
            pick = solve(idx, amount, sum + coins[idx], coins, dp) + 1;
            // System.out.println(pick);
        }
        
        int notpick = solve(idx + 1, amount, sum, coins, dp);
        // System.out.println(notpick);
        return dp[idx][sum] = Math.min(pick, notpick);
    }
}