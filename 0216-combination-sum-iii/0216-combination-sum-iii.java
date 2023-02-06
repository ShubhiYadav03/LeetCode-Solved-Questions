class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList();
        if(n <= k){
            return ans;
        }
        dfs(0, 0, n, k, list);
        
        return ans;
    }
    
    void dfs(int i, int sum, int n, int k, List<Integer> list){
        if(sum > n || (list.size() >= k && sum != n)) return;
        
        if(list.size() >= k && sum == n){
            List<Integer> li = new ArrayList(list);
            ans.add(li);
            return;
        }
        
        // sum += i; 
        for(int j = i + 1; j <= 9; j++){
            list.add(j);
            dfs(j, sum + j, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}