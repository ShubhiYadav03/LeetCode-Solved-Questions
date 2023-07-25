//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int node;
    int distance;
    
    Pair(int n, int d){
        node = n;
        distance = d;
    }
}
//User function Template for Java
class Solution {
	public int[] shortestPath(int n,int m, int[][] edges) {
		int[] distances = new int[n];
		for (int i = 0; i < n; i++)
                distances[i] = (int)1e9;
		
		List<List<Pair>> adj = new ArrayList();
        
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            //adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
     
        Stack<Integer> st = new Stack();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, adj, visited, st);
            }
        }
        distances[0] = 0; 
        while(!st.isEmpty()){
            int node = st.pop();
    
            for(Pair pair : adj.get(node)){
                int nx = pair.node;
    	        if(distances[nx] > distances[node] + pair.distance){
    	            distances[nx] = distances[node] + pair.distance;
    	        }
            }
        }
        for(int i = 0; i < n; i++){
            if(distances[i] == (int)1e9) distances[i] = -1;
        }
        return distances;
	}
	
	void dfs(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> st){
	   visited[node] = true;
	   
	   for(Pair pair : adj.get(node)){
	       int n = pair.node;
	       if(!visited[n]){
	           dfs(n, adj, visited, st);
	       }
	   } 
	   st.push(node);
	}
}