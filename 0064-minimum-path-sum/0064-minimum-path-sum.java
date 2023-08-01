class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return finPathSum(0, 0, grid, dp);
    }
    
    int finPathSum(int i, int j, int[][] grid, int[][] dp){
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int down = finPathSum(i + 1, j, grid, dp);
        int right = finPathSum(i, j + 1, grid, dp);
        
        return dp[i][j] = Math.min(finPathSum(i + 1, j, grid, dp), finPathSum(i, j + 1, grid, dp)) + grid[i][j];
    }
}