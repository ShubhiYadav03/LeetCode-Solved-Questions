class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList();
        // if(nums.length == ){
        //     return ans;
        // }
        dfs(0, nums);
        
        return ans;
    }
    
    void dfs(int i, int[] nums){
         // if(i > nums.length) return;
        if(i == nums.length){
            List<Integer> list =Arrays.stream(nums).boxed().collect(Collectors.toList()); 
            ans.add(list);
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            swap(i, j, nums);
            dfs(i + 1, nums);
            swap(i, j, nums);
        }
    }
    
    void swap(int i, int j,  int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}