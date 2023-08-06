class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve(0, n - 1, s, dp);
        return (ans < (int)1e9) ? ans : 0;
    }

    int solve(int idx1, int idx2, String str, int[][] dp){
        int n = str.length();
        if(idx1 > idx2){
            return 0;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int pick = 0;
        if(str.charAt(idx1) == str.charAt(idx2)){
            pick = solve(idx1 + 1, idx2 - 1, str, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int notpick1 = solve(idx1, idx2 - 1, str, dp) + 1;
        int notpick2 = solve(idx1 + 1, idx2, str, dp) + 1;
        
        return dp[idx1][idx2] = Math.min(notpick1, notpick2);
    }
}