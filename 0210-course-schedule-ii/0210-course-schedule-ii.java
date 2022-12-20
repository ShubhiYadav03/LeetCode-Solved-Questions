class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int k = 0;
        int[] indegree = new int[numCourses];
        int  num = numCourses - 1;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList(numCourses);
        
        for(int i = 0; i < numCourses ; i++ ){
            adj.add(new ArrayList());
        }
        
        for(int i = 0; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++; 
        }
     
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses ; i++){
            if(indegree[i] == 0)  q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n] == 0) q.add(n);
            }
        }
        if(ans.size() != numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses ; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}