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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[src] = 0;
        
        Queue<Integer> q = new ArrayDeque();
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int next : adj.get(node)){
                if(distances[next] == -1){
                    distances[next] = distances[node] + 1;
                    q.add(next);
                }
            }
        }
        
        return distances;
    }
}