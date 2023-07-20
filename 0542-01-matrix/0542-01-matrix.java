class Pair {
    int row;
    int col;
    
    Pair(int r, int c){
        row = r;
        col = c;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int distance = 0;
        int[][] ans = new int[mat.length][mat[0].length];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Pair> q = new ArrayDeque();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0) q.add(new Pair(i, j));
            }
        }
        
        while(!q.isEmpty()){
            int len = q.size();
            distance += 1;
            for(int i = 0; i < len; i++){
                Pair pair = q.remove();
                int row = pair.row;
                int col = pair.col;

                for(int j = 0; j < 4; j++){
                    if(isSafe(row + dy[j], col + dx[j], mat)){
                        mat[row + dy[j]][col + dx[j]] = 2;
                        ans[row + dy[j]][col + dx[j]] = distance;
                        q.add(new Pair(row + dy[j], col + dx[j]));
                    } 
                }   
            }
        }
        return ans;
    }
    
    boolean isSafe(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
            return false;
        
        return true;
    }
}