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
    
    int solve(int idx1, int idx2, String s, String t, int[][] dp){
        int m = s.length(), n = t.length();
        if(idx2 == n) return m - idx1;
        if(idx1 == m) return n - idx2;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int pick = 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            pick = solve(idx1 + 1, idx2 + 1, s, t, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int notpick = Math.min(solve(idx1 + 1, idx2, s, t, dp), solve(idx1, idx2 + 1, s, t, dp));
        notpick = Math.min(notpick, solve(idx1 + 1, idx2 + 1, s, t, dp)) + 1;
        
        return dp[idx1][idx2] = notpick;
    }
}