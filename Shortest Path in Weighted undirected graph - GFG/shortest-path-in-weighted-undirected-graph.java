//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int wt;
    int node;
    
    Pair(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList();
        
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.wt, pair2.wt));
        int[][] distances = new int[n + 1][2];
        for(int i = 0; i < n + 1; i++){
            distances[i][0] = (int)1e9;
            distances[i][1] = -1;
        }
        
        pq.add(new Pair(0, 1));
        distances[1][0] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int wt = p.wt;
            
            for(Pair next : adj.get(node)){
                int nextNode = next.node;
                int edgeWt = next.wt;
                if(distances[nextNode][0] > wt + edgeWt){
                    distances[nextNode][0] = wt + edgeWt;
                    distances[nextNode][1] = node;
                    pq.add(new Pair(distances[nextNode][0], nextNode));
                }
            }
        }
        
        for(int i = 0; i < n + 1; i++){
            if(distances[i][0] == (int)1e9) distances[i][0] = -1;
        }
        
        List<Integer> ans = new ArrayList();
        int i = distances[n][1];
        if(i == -1){
            ans.add(-1);
            return ans;
        }
        
        ans.add(n);
        
        while(i != -1){
            ans.add(i);
            i = distances[i][1]; 
        }
        Collections.reverse(ans);
        // if(ans.get(0) == 1){
        //     List<Integer> not = new ArrayList();
        //     not.add(-1);
        //     return not;
        // }
        return ans;
    }
}