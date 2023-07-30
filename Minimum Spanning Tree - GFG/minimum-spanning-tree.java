//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int wt;
    
    Pair(int n, int w){
        node = n;
        wt = w;
    }
}

class Solution{
	static int spanningTree(int n, int E, int edges[][]){
	    List<List<Pair>> adj = new ArrayList();
        
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
	    pq.add(new Pair(0, 0));
	    boolean[] visited = new boolean[n];
	    int mstWt = 0;
	    while(!pq.isEmpty()){
	        Pair p = pq.remove();
	        int node = p.node;
	        int wt = p.wt;
	        
	        if(!visited[node]){
	            visited[node] = true;
	            mstWt += wt;
	            for(Pair nextNode : adj.get(node)){
	                pq.add(nextNode);
	            }
	        }
	    }
	    return mstWt;
	}	
}