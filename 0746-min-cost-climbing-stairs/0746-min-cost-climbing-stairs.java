class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int curr = cost[cost.length - 1], prev = cost[cost.length - 2];
        
        for(int i = cost.length - 3; i >= 0; i--){
            cost[i] = Math.min(curr, prev) + cost[i];
            curr = prev;
            prev = cost[i];
        }
        
        return Math.min(curr, prev);
    }
}