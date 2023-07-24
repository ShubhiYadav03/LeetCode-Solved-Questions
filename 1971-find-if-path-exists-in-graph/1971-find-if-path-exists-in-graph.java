class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        return dfs(source, adj, visited, destination);
    }
    
    boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, int destination){
        if(node == destination) return true;
        visited[node] = true;
        
        for(int n : adj.get(node)){
            if(!visited[n]){
                if(dfs(n, adj, visited, destination)) return true;
            }
        }
        
        return false;
    }
}