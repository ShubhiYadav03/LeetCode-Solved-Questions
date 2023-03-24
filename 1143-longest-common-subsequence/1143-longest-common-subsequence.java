class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.equals(text2)) return text1.length();
//         int m = text1.length(), n = text2.length();
//         int[][] dp = new int[m][n];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         return solve(0, 0, text1, text2, dp);
        
        return tabulation(text1, text2);
    }
    // TABULATION
    int tabulation(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int idx1 = m - 1; idx1 >= 0; idx1--){
            for(int idx2 = n - 1; idx2 >= 0; idx2--){
                int equal = 0;
                if(text1.charAt(idx1) == text2.charAt(idx2))
                    equal = dp[idx1 + 1][idx2 + 1] + 1;
        
                int pick1 = dp[idx1][idx2 + 1];
                int pick2 = dp[idx1 + 1][idx2];
        
                dp[idx1][idx2] = Math.max(equal, Math.max(pick1, pick2));
            }
        }
        return dp[0][0];
    }
    
    int solve(int idx1, int idx2, String text1, String text2, int[][] dp){
        int m = text1.length(), n = text2.length();
        if(idx1 == m || idx2 == n){
            return 0;
        }
        
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        int equal = 0;
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            equal = solve(idx1 + 1, idx2 + 1, text1, text2, dp) + 1;
        }
        int pick = solve(idx1, idx2 + 1, text1, text2, dp);
        int notpick = solve(idx1 + 1, idx2, text1, text2, dp);
        
        return dp[idx1][idx2] = Math.max(equal, Math.max(pick, notpick));
    }
}