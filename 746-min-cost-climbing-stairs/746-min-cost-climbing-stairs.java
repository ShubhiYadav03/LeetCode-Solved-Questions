class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int last = 0, prev = cost[cost.length - 1];
        for(int i = cost.length - 2; i >= 0; i--){
        cost[i] = cost[i] + Math.min(last, prev);
        last = prev;
        prev = cost[i];
        }
        return Math.min(cost[0], cost[1]);
    }
    
    
    
}