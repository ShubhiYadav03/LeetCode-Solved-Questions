class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, word1, word2, dp);
    }
    
    int solve(int idx1, int idx2, String word1, String word2,  int[][] dp){
        int m = word1.length(), n = word2.length();
        if(idx2 == n ) return m - idx1;
        if(idx1 == m) return n - idx2;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            int pick = solve(idx1 + 1, idx2 + 1, word1, word2, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int delete = solve(idx1 + 1, idx2, word1, word2, dp);
        int insert = solve(idx1, idx2 + 1, word1, word2, dp);
        int replace = solve(idx1 + 1, idx2 + 1, word1, word2, dp);
        
        return dp[idx1][idx2] = Math.min(delete, Math.min(insert, replace)) + 1;
    }
}