class Solution {
    int max = 0;
    public int numEnclaves(int[][] grid) {
        int enclaves = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(dfs(grid, i, j)){
                        enclaves += max;
                    }
                    max = 0;
                }
            }
        }
        return enclaves;
    }
    
    boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if(grid[i][j] == 0) return true;
        grid[i][j] = 0;
        
        
        boolean top = dfs(grid, i - 1, j);
        boolean bottom = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        
        if(left && right && top && bottom) max += 1;

        return left && right && top && bottom;
    }
}