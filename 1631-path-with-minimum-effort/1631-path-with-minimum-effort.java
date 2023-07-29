class Pair{
    int row;
    int col;
    int diff;

    Pair(int r, int c, int d){
        row = r;
        col = c;
        diff = d;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.diff, pair2.diff));
        
        int[] dy = { -1, 1, 0 , 0};
        int[] dx = { 0, 0, -1, 1 };
        
        int[][] diffs = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                diffs[i][j] = (int)1e9;
            }
        }
        diffs[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int diff = p.diff;
            if(row == m - 1 && col == n - 1) return diff;
            for(int i = 0; i < 4; i++){
                int r = row + dy[i], c = col + dx[i];
                
                if(isSafe(r, c, m , n)){
                    int newEffort = Math.max(diff, Math.abs(heights[r][c] - heights[row][col]));
                    if(diffs[r][c] > newEffort){
                        diffs[r][c] = newEffort;
                        pq.add(new Pair(r, c, newEffort));
                    }
                }      
            }
        }
        return diffs[m - 1][n - 1];
    }
    
    boolean isSafe(int r, int c, int m, int n){
        if(r < 0 || c < 0 || r > m - 1 || c > n - 1) return false;
        
        return true;
    }
}