class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i = 0; i < dislikes.length; i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        boolean[] col = new boolean[n + 1];
        int[] visited = new int[n + 1];
        
       for(int i = 1; i <= n; i++){    
               if(visited[i] == 0){
                   if(!bipartite(i, adj, visited, col)) return false;
               }
       }
        return true;
    
    }
    
    public boolean bipartite(int i, List<List<Integer>> adj, int[] visited, boolean[] col) {
        
        Queue<Integer> q = new ArrayDeque<>();       
        q.add(i);
        visited[i] = 1;
        col[i] = true;
      
        while(!q.isEmpty()){
            int node = q.remove();
            boolean colour = !col[node];
            for(int neighbour : adj.get(node)){ 
                if(visited[neighbour] == 0){
                    q.add(neighbour);
                    visited[neighbour] = 1;
                    col[neighbour] = colour;
                }else if(col[neighbour] != colour) return false;
            }
        }

        return true;
    }
}