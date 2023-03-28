class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, n - 1, s, dp);
    }
    // mdabadm
    // mdabm
    int solve(int idx, int rev, String s, int[][] dp){
        int n = s.length();
        if(idx >= rev) return 0;

        
        if(dp[idx][rev] != -1) return dp[idx][rev];
        
        int pick = Integer.MAX_VALUE;
        if(s.charAt(idx) == s.charAt(rev)){
            pick = solve(idx + 1, rev - 1, s, dp);
            return dp[idx][rev] = pick;
        }
        
        int notpick = Math.min(solve(idx + 1, rev, s, dp), solve(idx, rev - 1, s, dp)) + 1;
        
        return dp[idx][rev] = notpick;
    }
}