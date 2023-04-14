class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // int[][] dp = new int[n][n];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return solve(0, n - 1, s, dp);
        
        return tabulation(s, n);
    }
    
    int tabulation(String s, int n){
        int[][] dp = new int[n + 1][n + 1];
        
        for(int idx1 = n - 1; idx1 >= 0; idx1--){
            for(int idx2 = 1; idx2 < n + 1; idx2++){
                if(s.charAt(idx1) == s.charAt(idx2 - 1))
                    dp[idx1][idx2] = dp[idx1 + 1][idx2 - 1] + 1;
                else 
                    dp[idx1][idx2] = Math.max(dp[idx1 + 1][idx2], dp[idx1][idx2 - 1]);
            }
        }
        
        return dp[0][n];
    }
    
    int solve(int idx1, int idx2, String s, int[][] dp){
        int n = s.length();
        if(idx1 == n || idx2 < 0){
            return 0;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s.charAt(idx1) == s.charAt(idx2)){
            return dp[idx1][idx2] = solve(idx1 + 1, idx2 - 1, s, dp) + 1;
        }
        
        return dp[idx1][idx2] = Math.max(solve(idx1 + 1, idx2, s, dp), solve(idx1, idx2 - 1, s, dp));
             
    }
}