class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList();
        if(n == 1){
            list.add(1);
            ans.add(list);
            return ans;
        }
        dfs(0, n, k, list);
        
        return ans;
    }
    
    void dfs(int i, int n, int k, List<Integer> list){
        if(list.size() >= k){
            List<Integer> li = new ArrayList(list);
            ans.add(li);
            return;
        }
        
        for(int j = i + 1; j <= n; j++){
            list.add(j);
            dfs(j, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}