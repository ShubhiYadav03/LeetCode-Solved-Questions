class Solution {
    public int closedIsland(int[][] grid) {
        int islands=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        islands+=1;
                    }
                    
                }
            }
        }
        return islands;
    }
    
    boolean dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ) return false;
        if(grid[i][j]==1) return true;
        grid[i][j]=1;
        
        boolean top=dfs(grid,i-1,j);
        boolean bottom=dfs(grid,i+1,j);
        boolean left=dfs(grid,i,j-1);
        boolean right=dfs(grid,i,j+1);
        
        return left&&right&&top&&bottom;
    }
}