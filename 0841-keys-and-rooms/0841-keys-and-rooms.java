class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs(0, rooms, visited);
        
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    
    void dfs(int i, List<List<Integer>> rooms, boolean[] visited){
        visited[i] = true;
        for(int n : rooms.get(i)){
            if(!visited[n]) dfs(n, rooms, visited);
        }
    }
}