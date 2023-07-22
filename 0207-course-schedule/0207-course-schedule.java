class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int i,  List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        visited[i] = true;
        pathVisited[i] = true;
        
        for(int n : adj.get(i)){
            if(pathVisited[n]){
                return true;
            }
            if(!visited[n]){
                if(dfs(n, adj, visited, pathVisited))
                    return true;
            }
        }
        pathVisited[i] = false;
        return false;
    }
}