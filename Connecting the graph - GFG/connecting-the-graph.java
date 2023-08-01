//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
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
            size.set(ulpv, size.get(ulpu) + size.get(ulpv));
        }
        else{
            parent.set(ulpv, ulpu);
            size.set(ulpu, size.get(ulpu) + size.get(ulpv));
        }
    }
}
class Solution {

    public int Solve(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdge = 0;
        for(int i = 0; i < edge.length; i++){
            if(ds.findUlPar(edge[i][0]) == ds.findUlPar(edge[i][1])) 
                extraEdge++;
            else
                ds.unionBySize(edge[i][0], edge[i][1]);
        }
        
        int components = 0;
        for(int i = 0; i < ds.parent.size(); i++){
            if(i == ds.parent.get(i)){
                components++;
            }
        }
        
        if(components - 1 <= extraEdge){
            return components - 1;
        }
        else
            return -1;
    }
}