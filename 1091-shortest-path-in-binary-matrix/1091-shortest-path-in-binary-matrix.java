class Pair{
    int row;
    int col;
    int steps;
    Pair(int r, int c, int s){
        row = r;
        col = c;
        steps = s;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
    
        int[] diry = { -1, 1, 0 };
        int[] dirx = { 0, -1, 1 };
        Queue<Pair> q = new ArrayDeque<>();
        int[][] distances = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                distances[i][j] = (int)1e9;
            }
        }
    
        q.add(new Pair(0, 0, 1));
        distances[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int steps = p.steps;
            
            for(int dy : diry){
                for(int dx : dirx){
                    if(dy == 0 && dx == 0) continue;
                    int r = row + dy, c = col + dx;
                    if(r == n - 1 && c == n - 1) return steps + 1;
                    if(isSafe(r, c, n) && grid[r][c] == 0 && distances[r][c] > steps + 1){
                        distances[r][c] = steps + 1;
                        q.add(new Pair(r, c, steps + 1));
                    }
                }
            }
        }
        return (distances[n - 1][n - 1] != (int)1e9) ? distances[n - 1][n - 1] : -1;
    }
    
    boolean isSafe(int r, int c, int n){
        if(r < 0 || c < 0 || r > n - 1 || c > n - 1) return false;
        
        return true;
    }
}