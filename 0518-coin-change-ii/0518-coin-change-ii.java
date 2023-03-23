class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        
//         int[][] dp = new int[coins.length][amount + 1];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
        // int ans = solve(0, amount, 0, coins, dp);
        // return ans;
        return tabulation(amount, coins);
        
    }
    
    int tabulation(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[n][amount] = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = amount; j >= 0; j--){
                int pick = 0;
                if(amount >= j + coins[i])
                    pick = dp[i][j + coins[i]];
                int notpick = dp[i + 1][j];
                
                dp[i][j] = pick + notpick;
            }
        }
        
        return dp[0][0];
    }
    
    int solve(int idx, int amount, int sum, int[] coins, int[][] dp){
        int n = coins.length;
        if(idx == n && sum == amount){
            return 1;
        }
        
        if(idx == n){
            return 0;
        }
        
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int pick = 0;
        if(amount >= sum + coins[idx]){
            pick = solve(idx, amount, sum + coins[idx], coins, dp);
            // System.out.println(pick);
        }
        
        int notpick = solve(idx + 1, amount, sum, coins, dp);
        // System.out.println(notpick);
        return dp[idx][sum] = pick + notpick;
    
    }
}