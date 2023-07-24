class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return findpaths(0, 0, dp);
    }
    
    int findpaths(int m, int n, int[][] dp){
        if(m == dp.length - 2 && n == dp[0].length - 2) return 1; 
        if(m == dp.length - 1 || n == dp[0].length - 1) return 0;
        
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = findpaths(m + 1, n, dp) + findpaths(m, n + 1, dp);
    }
}