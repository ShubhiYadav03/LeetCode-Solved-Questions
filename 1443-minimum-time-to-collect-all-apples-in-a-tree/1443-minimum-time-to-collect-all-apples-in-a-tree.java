class Solution {
    int time = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, -1, adj, hasApple);  
        return time;
    }
    
    boolean dfs(int i, int par, List<List<Integer>> adj, List<Boolean> hasApple){
        boolean apple = false;
        for(int n : adj.get(i)){
            if(n != par){
                time++;
                boolean b = dfs(n, i, adj, hasApple);
                apple = apple | b;
                if(!b) time--;
                else time++;
            }
        }
        
        if(hasApple.get(i)){
            return true;
        } 
        return apple;
    }
}