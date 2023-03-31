class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) 
            Arrays.fill(row, -1);
        
        return lis(-1, 0, nums, dp);
    }
    
    int lis(int idx1, int idx2, int[] nums, int[][] dp){
        int n = nums.length;
        if(idx2 == n || idx1 == n) return 0;
        
        if(dp[idx1 + 1][idx2] != -1) return dp[idx1 + 1][idx2];
        int pick = 0;
        if(idx1 == -1 || nums[idx2] > nums[idx1]){
            pick = lis(idx2, idx2 + 1, nums, dp) + 1;
        }
        
        int notpick = lis(idx1, idx2 + 1, nums, dp);
            
        return dp[idx1 + 1][idx2] = Math.max(pick, notpick);
    }
}