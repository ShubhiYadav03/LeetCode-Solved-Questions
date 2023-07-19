class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if(n == 1) return 1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, adj);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    void dfs(int i, boolean[] visited, List<List<Integer>> adj){
        visited[i] =true;
        
        for(int n : adj.get(i)){
            if(!visited[n])
                dfs(n, visited, adj);
        }
    }
}