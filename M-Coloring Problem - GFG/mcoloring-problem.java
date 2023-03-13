//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] col = new int[n];
        // int[] visited = new int[graph.length];
        
        return helper(0, graph, col, m, n);

    }
    
    public boolean helper(int node, boolean[][] graph, int[] col,  int m, int n) {
        if(node == n) return true;
        
        for(int i = 1; i <= m; i++){
            if(isSafe(i, node, graph, col, m, n)){
                col[node] = i;
                if(helper(node + 1, graph, col, m, n)) return true;
            }
        }
        
        return false;
    }
    
    public boolean isSafe(int colour, int node, boolean[][] graph, int[] col,  int m, int n){
        for(int i = 0; i < n; i++){
            if(node != i && graph[node][i] && col[i] == colour){
                return false;
            }
        }
        
        return true;
    }
}