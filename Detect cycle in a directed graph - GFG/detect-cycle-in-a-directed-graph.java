//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }
    
    boolean dfs(int i,  ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        visited[i] = true;
        pathVisited[i] = true;
        
        for(int n : adj.get(i)){
            if(pathVisited[n]){
                return true;
            }
            if(!visited[n]){
                if(dfs(n, adj, visited, pathVisited))
                    return true;
            }
        }
        pathVisited[i] = false;
        return false;
    }
}