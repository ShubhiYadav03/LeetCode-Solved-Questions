class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList();
        // if(nums.length == ){
        //     return ans;
        // }
        HashSet<List<Integer>> set = new HashSet();
        dfs(0, nums, set);
        List<List<Integer>> ans = new ArrayList<List<Integer>>(set);
        return ans;
    }
    
    void dfs(int i, int[] nums, HashSet<List<Integer>> set){
         // if(i > nums.length) return;
        if(i == nums.length){
            List<Integer> list =Arrays.stream(nums).boxed().collect(Collectors.toList()); 
            set.add(list);
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            if((i != j && nums[i] == nums[j])){
                // dfs(i + 1, nums);
                continue;
            } 
            else{
                swap(i, j, nums);
                dfs(i + 1, nums, set);
                swap(i, j, nums);
            }
        }
    }
    
    void swap(int i, int j,  int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}