//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int m = grid.length, n = grid[0].length;
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        int[] dy = { -1, 1, 0 , 0};
        int[] dx = { 0, 0, -1, 1 };
        Queue<Pair> q = new ArrayDeque<>();
        int[][] distances = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                distances[i][j] = (int)1e9;
            }
        }
    
        q.add(new Pair(source[0], source[1]));
        distances[source[0]][source[1]] = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int steps = distances[row][col];
            
            for(int i = 0; i < 4; i++){
                int r = row + dy[i], c = col + dx[i];
                if(r == destination[0] && c == destination[1]) return steps + 1;
                if(isSafe(r, c, m, n) && grid[r][c] == 1 && distances[r][c] > steps + 1){
                    distances[r][c] = steps + 1;
                    q.add(new Pair(r, c));
                }
            }
        }
        return -1;
    }
    
    boolean isSafe(int r, int c, int m, int n){
        if(r < 0 || c < 0 || r > m - 1 || c > n - 1) return false;
        
        return true;
    }
}
