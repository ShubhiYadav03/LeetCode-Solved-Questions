class Solution {
    int[] dx = {-1, 0, 1};
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        int collected = pickup(0, 0, n - 1, grid, dp);
        return (collected >= 0) ? collected : 0;
    }
     
    int pickup(int row, int c1, int c2, int[][] grid, int[][][] dp){
        int m = grid.length, n = grid[0].length;
        if(row >= m || c1 < 0 || c2 < 0 || c1 >= n || c2 >= n) return 0;
        
        if(row == m){
            return grid[row][c1] + grid[row][c1];
        }
        
        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];
        
        int cherries = 0;
        if(c1 == c2)
            cherries = grid[row][c1];
        else 
            cherries = grid[row][c1] + grid[row][c2]; 
        int max = 0;
        for(int x1 : dx){
            for(int x2 : dx){
                max = Math.max(max, pickup(row + 1, c1 + x1, c2 + x2, grid, dp));
            }
        }
        
        return dp[row][c1][c2] = cherries + max;
    }
}