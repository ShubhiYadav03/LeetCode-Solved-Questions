class Solution {
    int count=0;
    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count = dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 1;
        if(grid[i][j]==2) return 0;
        
        grid[i][j]=2;
        int top=dfs(grid,i-1,j);
        int bottom=dfs(grid,i+1,j);
        int left=dfs(grid,i,j-1);
        int right=dfs(grid,i,j+1);
        
        return left+right+top+bottom;
    }
}