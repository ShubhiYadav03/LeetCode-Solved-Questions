class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathvis = new boolean[graph.length];
        int[] safe = new int[graph.length];
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                safeNodes(i, graph, pathvis, visited, safe);
            }
        }
        
        for(int i = 0; i < graph.length; i++){
             if(safe[i] == 0) res.add(i);
        }
        
        return res;
    }

    boolean safeNodes(int i, int[][] graph, boolean[] visited, boolean[] pathvis, int[] safe){
        visited[i] = true;
        pathvis[i] = true;

        for(int n : graph[i]){
            if(!visited[n]){
                boolean cycle = safeNodes(n, graph, pathvis, visited, safe);
                if(cycle){
                    safe[i] = 1;
                    return cycle;
                }
            }
            else if(pathvis[n]){
                safe[i] = 1;
                return true;
            }
            // else if(visited[n] && safe[n] == 1) safe[i] = 1;
        }
        pathvis[i] = false;
        return false;
    }
}