class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int  num = numCourses - 1;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList(numCourses);
        
        for(int i = 0; i < numCourses ; i++ ){
            adj.add(new ArrayList());
        }
        
        for(int i = 0; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] pathvis = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            // if(adj.get(i).size() == 0) continue;
            
            if(!visited[i]){
                if(dfs(i, visited, pathvis, st, adj)) return new int[]{};
            }
        }
        
        while(!st.isEmpty()){
            ans[num] = st.pop();
            num--;
        }
//         if(num >= 0){
//             while(num >= 0){ ans[num] = numCourses - num - 1;
//                             num--;
//                            }
            
//         }
        
        return ans;
    }
    
     boolean dfs(int i, boolean[] visited, boolean[] pathvis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        visited[i] = true;
        pathvis[i] = true;
        for(int n : adj.get(i)){
            if(!visited[n]){
                if(dfs(n, visited, pathvis, st, adj)) return true;
            }else if(pathvis[n]){
                return true;
            }
        }
        st.push(i);
        pathvis[i] = false;
        return false;
    }
}