class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0, maxPrice = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else{
                maxPrice = Math.max(maxPrice, prices[i] - buy);
            }
        }
        return maxPrice;
    }
}