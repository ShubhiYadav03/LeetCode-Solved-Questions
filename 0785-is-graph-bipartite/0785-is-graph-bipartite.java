class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(!dfs(i, graph, true, visited, color)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int i, int[][] graph, boolean color, boolean[] visited, boolean[] colorArr){
        visited[i] = true;
        colorArr[i] = color;
        
        for(int n : graph[i]){
            if(visited[n] && colorArr[n] == color){
                return false;
            }
            if(!visited[n]){
                if(!dfs(n, graph, !color, visited, colorArr))
                    return false;
            }
        }
        
        return true;
    }
}