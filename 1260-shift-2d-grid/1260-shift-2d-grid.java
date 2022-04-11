class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length-1;
        int n=grid[0].length-1;
        int temp=grid[0][0];
      for(int s=0;s<k;s++) { 
      for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
          if(i==0&&j==0) continue;  
           swap(grid,i,j);                 
          }
      }  
      }
        
    List<List<Integer>> list = new ArrayList<>();
    for(int[] rows : grid) {
list.add(Arrays.stream(rows).boxed().collect(Collectors.toList()));       }

        return list;
      
     
    }
    void swap(int[][] grid,int i,int j){
        int temp=grid[0][0];
        grid[0][0]=grid[i][j];
        grid[i][j]=temp;
    }
} 