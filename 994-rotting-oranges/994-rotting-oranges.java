class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque();
        Boolean empty = true; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.add(new Pair(i, j));
                if(grid[i][j] == 1 || grid[i][j] == 1) empty = false;
            }
        }
        
        if(empty) return 0;
        if(q.isEmpty()) return -1;
        int hr = -1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Pair p = q.poll();
                int row = p.row, col = p.col;
                if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    q.add(new Pair(row - 1, col));
                }
                if(row + 1 < grid.length && grid[row + 1][col] == 1){
                    grid[row + 1][col] = 2;
                    q.add(new Pair(row + 1, col));
                }
                if(col - 1 >= 0 && grid[row][col - 1] == 1){
                    grid[row][col - 1] = 2;
                    q.add(new Pair(row, col - 1));
                }
                if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
                    grid[row][col + 1] = 2;
                    q.add(new Pair(row, col + 1));
                }
            } 
            hr++;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return hr;
    }
}