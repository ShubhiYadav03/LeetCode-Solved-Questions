class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        // int[][] dp = new int[coins.length][amount + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // int ans = solve(0, amount, 0, coins, dp);
        // if(ans == Integer.MAX_VALUE || ans >= (int)Math.pow(10, 9)) return -1;
        // return ans;
        int ans = tabulation(coins, amount);
        if(ans == Integer.MAX_VALUE || ans >= (int)Math.pow(10, 9)) return -1;
        return ans;
    }
    
    int tabulation(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        for(int sum = 0; sum <= amount; sum++){
            if((amount - sum)% coins[n - 1] == 0) 
                dp[n - 1][sum] = (amount - sum) / coins[n - 1];
            else dp[n - 1][sum] = Integer.MAX_VALUE;
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = amount; j >= 0; j--){
                int pick = (int)Math.pow(10, 9);
                if(amount >= j + coins[i])
                    pick = dp[i][j + coins[i]] + 1;
                int notpick = dp[i + 1][j];
                
                dp[i][j] = Math.min(pick, notpick);
            }
        }
        return dp[0][0];
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