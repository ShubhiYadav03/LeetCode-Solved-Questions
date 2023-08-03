class Solution {
    int maxCherries = 0;
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][m];
        
        int collected = solve(0, 0, 0, grid, dp);
        return (collected > 0) ? collected : 0;
    }
    
    int solve(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int m = grid.length, n = grid[0].length, c2 = r1 + c1 - r2;
        if(r1 == m ||  c1 == n || r2 == m || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) 
            return Integer.MIN_VALUE;
        
        if(r1 == m - 1  && c1 == n - 1){
            return grid[m - 1][n - 1];
        }
        
        if(dp[r1][c1][r2] != 0) return dp[r1][c1][r2];
        
        int cherries = 0;
        if(r1 == r2 && c1 == c2)
            cherries = grid[r1][c1];
        else 
            cherries = grid[r1][c1] + grid[r2][c2];; 
        
        int f1 = solve(r1 + 1, c1, r2 , grid, dp);
        int f2 = solve(r1 + 1, c1, r2 + 1 , grid, dp);
        int f3 = solve(r1, c1 + 1, r2 + 1 , grid, dp);
        int f4 = solve(r1, c1 + 1, r2 , grid, dp);

        return dp[r1][c1][r2] = cherries + Math.max(Math.max(f1, f2), Math.max(f3, f4));
    }
}