class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        
        
        return profit(0, 1, prices, dp, fee);
    }
    
    int profit(int idx, int buy, int[] prices, int[][] dp, int fee){
        if(idx == prices.length) return 0;
        
        if(dp[idx][buy] != Integer.MIN_VALUE) return dp[idx][buy];
        
        int pick = Integer.MIN_VALUE;
        if(buy == 1){
            pick = Math.max(profit(idx + 1, 0, prices, dp, fee) - prices[idx], profit(idx + 1, 1, prices, dp, fee));
            // return pick;
        }else{
        
        pick = Math.max(profit(idx + 1, 1, prices, dp, fee) + prices[idx] - fee, profit(idx + 1, 0, prices, dp, fee));
        }
        return dp[idx][buy] = pick;
        
    }
}