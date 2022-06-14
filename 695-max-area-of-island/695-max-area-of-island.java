class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int area=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    area=dfs(grid,i,j);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    
    int dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        
        grid[i][j]=0;
        
        int top=dfs(grid,i-1,j);
        int bottom=dfs(grid,i+1,j);
        int left=dfs(grid,i,j-1);
        int right=dfs(grid,i,j+1);
        
        return left+right+top+bottom+1;
    }
}