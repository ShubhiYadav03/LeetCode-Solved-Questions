class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(start,visited,arr);
    }
    
    boolean dfs(int start, boolean[] visited, int[] arr){
        if(arr[start] == 0)
			return true;
        if(visited[start] || (arr[start]+start >= arr.length && start-arr[start] < 0)) return false;

        visited[start] = true;
        if(arr[start]+start >= arr.length) return dfs(start-arr[start], visited, arr);
        if(start-arr[start] < 0) return dfs(arr[start]+start, visited, arr);
        
         
        return dfs(arr[start]+start, visited, arr) || dfs(start-arr[start], visited, arr);
    }
}