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

class DisjointSet{
    List<Integer> parent = new ArrayList();
    List<Integer> size = new ArrayList();
    
    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUlPar(int node){
        if(parent.get(node) == node)
            return node;
        int ulp = findUlPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    
    void unionBySize(int u, int v){
        int ulpu = findUlPar(u);
        int ulpv = findUlPar(v);
        
        if(ulpu < ulpv){
            parent.set(ulpu, ulpv);
            size.set(ulpv, size.get(ulpu));
        }
        else{
            parent.set(ulpv, ulpu);
            size.set(ulpu, size.get(ulpv));
        }
    }
}

class Solution{
	static int spanningTree(int n, int E, int edges[][]){
	    
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
	    
	    boolean[] visited = new boolean[n];
	    int mstWt = 0;
	    DisjointSet ds = new DisjointSet(n);
	    
	    for(int i = 0; i < E; i++){
	        if(ds.findUlPar(edges[i][0]) != ds.findUlPar(edges[i][1])){
	            mstWt += edges[i][2];
	            ds.unionBySize(edges[i][0], edges[i][1]);
	        }
	    }
	    return mstWt;
	}	
}