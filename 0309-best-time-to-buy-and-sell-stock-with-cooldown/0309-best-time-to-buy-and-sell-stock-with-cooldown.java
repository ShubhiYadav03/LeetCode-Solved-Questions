class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return profit(0, 1, prices, dp);
    }
    
    int profit(int idx, int buy, int[] prices, int[][] dp){
        if(idx >= prices.length) return 0;
        
        if(dp[idx][buy] != -1) return dp[idx][buy];
        
        int pick = Integer.MIN_VALUE;
        if(buy == 1){
            pick = Math.max(profit(idx + 1, 0, prices, dp) - prices[idx], profit(idx + 1, 1, prices, dp));
            return dp[idx][buy] = pick;
        }
        
        pick = Math.max(profit(idx + 2, 1, prices, dp) + prices[idx], profit(idx + 1, 0, prices, dp));
        return dp[idx][buy] = pick;
        
    }
}