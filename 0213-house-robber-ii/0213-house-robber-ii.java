class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        
        return Math.max(houseRobber(Arrays.copyOfRange(nums, 0, nums.length - 1)), houseRobber(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    
    public int houseRobber(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        // if(nums.length == 3) return Math.max(nums[1], nums[0] + nums[2]);
        
        
        int prev = nums[0], curr = nums[1];
        nums[2] = nums[0] + nums[2];
        for(int i = 3; i < nums.length; i++){
            nums[i] = Math.max(curr, prev) + nums[i];
            prev = curr;
            curr = nums[i - 1];
        }
        
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

}