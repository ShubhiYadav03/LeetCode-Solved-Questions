class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = prices[0];
        
        for(int i = 0; i < prices.length; i++){
            int profit = prices[i] - minPrice;
            max = Math.max(profit, max);
            minPrice = Math.min(minPrice, prices[i]); 
        }
        
        return max;
    }
}