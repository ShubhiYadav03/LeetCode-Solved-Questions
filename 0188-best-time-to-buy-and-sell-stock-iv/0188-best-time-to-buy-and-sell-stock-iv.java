class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int[][] mat : dp){
            for(int[] row : mat)
                Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        return profit(0, 1, prices, k, dp);
    }
    
    int profit(int idx, int buy, int[] prices, int transactions, int[][][] dp){
        if(idx == prices.length || transactions == 0) return 0;
        
        if(dp[idx][buy][transactions] != Integer.MIN_VALUE) return dp[idx][buy][transactions];
        
        int pick = Integer.MIN_VALUE;
        if(buy == 1){
            pick = Math.max(profit(idx + 1, 0, prices, transactions, dp) - prices[idx], profit(idx + 1, 1, prices, transactions, dp));
            // return pick;
        }else{
        
        pick = Math.max(profit(idx + 1, 1, prices, transactions - 1, dp) + prices[idx], profit(idx + 1, 0, prices, transactions, dp));
        }
        return dp[idx][buy][transactions] = pick;
        
    }
}