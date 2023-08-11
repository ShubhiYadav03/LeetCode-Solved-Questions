class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
    
        int[][] dp = new int[coins.length + 1][amount + 2];
        dp[coins.length][amount] = 1;
        for(int idx = coins.length - 1; idx >= 0; idx--){
            for(int sum = amount; sum >= 0; sum--){
                int pick = 0;
                if(coins[idx] + sum <= amount && sum + coins[idx] >= 0){
                    pick = dp[idx][sum + coins[idx]];
                }
                int notpick = dp[idx + 1][sum];

                dp[idx][sum] = pick + notpick;
            }
        }
        return dp[0][0];
    }
}