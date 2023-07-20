class Pair {
    int row;
    int col;
    
    Pair(int r, int c){
        row = r;
        col = c;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int time = -1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Pair> q = new ArrayDeque();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.add(new Pair(i, j));
            }
        }
        
        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int i = 0; i < len; i++){
                Pair pair = q.remove();
                int row = pair.row;
                int col = pair.col;

                for(int j = 0; j < 4; j++){
                    if(isSafe(row + dy[j], col + dx[j], grid)){
                        grid[row + dy[j]][col + dx[j]] = 2;
                        q.add(new Pair(row + dy[j], col + dx[j]));
                    } 
                }   
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return (time >= 0) ? time : 0;
    }
    
    boolean isSafe(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
            return false;
        
        return true;
    }
}