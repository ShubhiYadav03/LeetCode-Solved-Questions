class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(start,visited,arr);
    }
    
    boolean dfs(int start, boolean[] visited, int[] arr){
        if(start < 0 || start >= arr.length || visited[start]) 
            return false;
        
        if(arr[start] == 0)
			return true;
    
        visited[start] = true;
        
        return dfs(arr[start]+start, visited, arr) || dfs(start-arr[start], visited, arr);
    }
}