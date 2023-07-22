class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList();
        
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Stack<Integer> st = new Stack();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(!dfs(i, adj, visited, pathVisited, st)){
                    return new int[]{};
                }
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        
        return ans;
    }
    
    boolean dfs(int node,  List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, Stack<Integer> st){
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int n : adj.get(node)){
            if(pathVisited[n])
                return false;
            if(!visited[n]){
                if(!dfs(n, adj, visited, pathVisited, st))
                    return false;
            }
        }
        
        pathVisited[node] = false;
        st.push(node);
        return true;
    }
}