class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max, num);
        }
        
        int[] freq = new int[max + 1];
        for(int num : nums){
            freq[num]++;
        }
        int[] dp =  new int[max + 1];
        Arrays.fill(dp, -1);
        return solve(1, freq, dp);
          
    }
    
    int solve(int num, int[] freq, int[] dp){
        if(num >= freq.length) return 0;
        
        if(dp[num] != -1) return dp[num];
        
        int pick = solve(num + 2, freq, dp) + freq[num] * num;
        int notpick = solve(num + 1, freq, dp);
        
        return dp[num] = Math.max(pick, notpick);
    }
}