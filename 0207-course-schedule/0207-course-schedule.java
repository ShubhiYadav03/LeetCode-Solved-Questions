class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList(numCourses);
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses ; i++ ){
            adj.add(new ArrayList());
        }
        
        for(int i = 0; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] pathvis = new boolean[numCourses];
        boolean[] visited=new boolean[numCourses];
        for(int i = 0;i < numCourses; i++){
            if(adj.get(i).size() == 0) continue;
            
            if(!visited[i]){
                if(dfs(i, visited, pathvis,adj)) return false;
            }
        }
        return true;
    }
    
     boolean dfs(int i, boolean[] visited, boolean[] pathvis, ArrayList<ArrayList<Integer>> adj){
        visited[i] = true;
        pathvis[i] = true;
        for(int n : adj.get(i)){
            if(!visited[n]){
                if(dfs(n, visited, pathvis, adj)) return true;
            }else if(pathvis[n]){
                return true;
            }
        }
        pathvis[i] = false;
        return false;
    }
}