class Solution {
    int ans = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            nums[i] = i;
        }
        
        dfs(1, nums);
        
        return ans;
    }
    
    void dfs(int i, int[] nums){
        if(i == nums.length){
            ans++;
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            swap(i, j, nums);
            if(nums[i] % i == 0 || i % nums[i] == 0){
                dfs(i + 1, nums);
            }
            swap(i, j, nums);
        }
    }
    
    void swap(int i, int j,  int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }   
    
}