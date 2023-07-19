class Solution {
    int landcells = 0;
    public int numEnclaves(int[][] grid) {
        int numEnclaves = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(dfs(i, j, grid))
                        numEnclaves += landcells;
                    landcells = 0;
                }
            }
        }
        
        return numEnclaves;
    }
    
    boolean dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if(grid[i][j] == 0) return true;
        
        grid[i][j] = 0;
        landcells += 1;
        
        boolean top = dfs(i - 1, j, grid);
        boolean bottom = dfs(i + 1, j, grid);
        boolean left = dfs(i, j - 1, grid);
        boolean right = dfs(i, j + 1, grid); 
        
        return top && bottom && left && right;
    }
}