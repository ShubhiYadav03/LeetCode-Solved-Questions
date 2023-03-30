class Solution {
    public int numDistinct(String s, String t) {
        if(s.equals(t)) return 1;
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, s, t, dp);
    }
    
    int solve(int idx1, int idx2, String s, String t, int[][] dp){
        int m = s.length(), n = t.length();
        if(idx2 == n) return 1;
        if(idx1 == m) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int pick = 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            pick = solve(idx1 + 1, idx2 + 1, s, t, dp);
        }
        
        int notpick = solve(idx1 + 1, idx2, s, t, dp);
        
        return dp[idx1][idx2] = pick + notpick;
    }
    
}