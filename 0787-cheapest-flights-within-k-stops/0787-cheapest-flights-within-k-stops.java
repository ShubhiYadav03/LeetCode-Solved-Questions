class Pair{
    int stops;
    int cost;
    int node;
    
    Pair(int stops, int node, int cost){
        this.stops = stops;
        this.cost = cost;
        this.node = node;
    }
    
    Pair(int node, int cost){
        this.cost = cost;
        this.node = node;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        List<List<Pair>> adj = new ArrayList();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        int[] costs = new int[n];
        for(int i = 0; i < n; i++){
            costs[i] = (int)1e9;
        }
        
        q.add(new Pair(0, src, 0));
        costs[src] = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int cost = p.cost;
            int stops = p.stops;
            if(stops > k) continue;
            for(Pair next : adj.get(node)){
                int nextNode = next.node;
                int edgeCost = next.cost;
                if(costs[nextNode] > cost + edgeCost && stops <= k){
                    costs[nextNode] = cost + edgeCost;
                    q.add(new Pair(stops + 1, nextNode, costs[nextNode]));
                }
            }
         
        }
        
        return (costs[dest] == (int)1e9) ? -1 : costs[dest];
    }
}