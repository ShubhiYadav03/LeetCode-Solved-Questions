class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, n - 1, s, dp);
    }
    int solve(int idx1, int idx2, String str, int[][] dp){
        int n = str.length();
        if(idx1 > idx2){
            return 0;
        }
        if(idx1 == idx2){
            return 1;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int pick = 0;
        if(str.charAt(idx1) == str.charAt(idx2)){
            pick = 2 + solve(idx1 + 1, idx2 - 1, str, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int notpick1 = solve(idx1, idx2 - 1, str, dp);
        int notpick2 = solve(idx1 + 1, idx2, str, dp);
        
        return dp[idx1][idx2] = Math.max(pick, Math.max(notpick1, notpick2));
    }
}