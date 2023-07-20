class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i = 0; i < nums.length;){
            int idx = nums[i] - 1;
            if(nums[i] != nums[idx]){
                swap(i, idx, nums);
            }
            else i++;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                return nums[i];
            }
        }
        return 0;
    }
    
    void swap(int i, int j, int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}