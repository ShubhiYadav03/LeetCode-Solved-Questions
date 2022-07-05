class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[2], Math.max(nums[0], nums[1]));
        
        return Math.max(houseRobber(Arrays.copyOfRange(nums, 0, nums.length - 1)), houseRobber(Arrays.copyOfRange(nums, 1, nums.length)));
        
    }
    int houseRobber(int[] nums){
           
        int prev = nums[nums.length - 1], last = 0;
        
        for(int i = nums.length - 3; i >=0; i--){
            nums[i] = nums[i] + Math.max(prev, last);
            last = prev;
            prev = nums[i + 1];
        }
        
        return Math.max(nums[0], nums[1]);
    }
}