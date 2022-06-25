class Solution {
    long size = 0;
    public long countPairs(int n, int[][] edges) {
        List<ArrayList<Integer>> list=new ArrayList(); 
        int[] visited=new int[n];
        long ans=0;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i=0;i<n;i++){
            if(visited[i]!=1){
                dfs(i,visited,list);
                ans+=size*(n-size);
                size=0;
            }
        }
        return ans/2;
    }
    
    void dfs(int i, int[] visited, List<ArrayList<Integer>> list){
        if(visited[i]==1) return;
        
        visited[i]=1;
        size+=1;
        for(int edge : list.get(i)){
            if(visited[edge]!=1){
                dfs(edge,visited,list);
            }
        }
    }
}