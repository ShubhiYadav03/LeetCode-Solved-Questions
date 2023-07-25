//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int wt;
    int node;
    
    Pair(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.wt, pair2.wt));
        int[] distances = new int[n];
        for(int i = 0; i < n; i++){
            distances[i] = (int)1e9;
        }
        
        pq.add(new Pair(0, src));
        distances[src] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int wt = p.wt;
            
            for(ArrayList<Integer> next : adj.get(node)){
                int nextNode = next.get(0);
                int edgeWt = next.get(1);
                if(distances[nextNode] > wt + edgeWt){
                    distances[nextNode] = wt + edgeWt;
                    pq.add(new Pair(distances[nextNode], nextNode));
                }
            }
        }
        return distances;
    }
}

