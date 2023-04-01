class Solution {
    boolean cycle = false;
    int min = Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < n ; i++ ){
            adj.add(new ArrayList());
        }
        
        for(int i = 0; i < edges.length ; i++){
            adj.get(edges[i][1]).add(edges[i][0]);
            adj.get(edges[i][0]).add(edges[i][1]);
             
        }
        
        for(int i = 0; i < n; i++){
            int[] visited = new int[n];
                // if(visited[i] == 0){
            dfs(i, -1, adj, visited, 1, map);
                // }
        }
        if(!cycle) return -1;
        return min;
    }
    
    void dfs(int i, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int len, Map<Integer, Integer> map){
        visited[i] = 1;
        map.put(i, len);
        for(int neighbour : adj.get(i)){
            if(visited[neighbour] != 1){
            dfs(neighbour, i, adj, visited, len + 1, map);
            } 
            else if(map.containsKey(neighbour) && neighbour != parent){
                cycle = true;
                min = Math.min(min, Math.abs(len - map.get(neighbour)) + 1);
            }
        }
    }
}