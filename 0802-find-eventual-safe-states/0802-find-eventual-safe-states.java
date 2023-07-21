class Solution {
    List<Integer> safeNodes = new ArrayList();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, graph, visited, pathVisited);
            }
        }
        
        Collections.sort(safeNodes);
        return safeNodes;
    }
    
    boolean dfs(int i, int[][] graph, boolean[] visited, boolean[] pathVisited){
        visited[i] = true;
        
        if(graph[i].length == 0){
            safeNodes.add(i);
            return true;
        }
        
        pathVisited[i] = true;
        
        if(graph[i].length == 0){
            safeNodes.add(i);
            return true;
        }
        for(int n : graph[i]){
            if(pathVisited[n]){
                return false;
            }
            if(!visited[n]){
                if(!dfs(n, graph, visited, pathVisited))
                    return false;
            }
        }
        
        safeNodes.add(i);
        pathVisited[i] = false;
        return true;
    }
}