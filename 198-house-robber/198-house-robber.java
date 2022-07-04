class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int prev = nums[nums.length - 2], last = nums[nums.length - 1];
        nums[nums.length - 3] = nums[nums.length - 3] + nums[nums.length - 1];
        for(int i = nums.length - 4; i >=0; i--){
            nums[i] = nums[i] + Math.max(prev, last);
            last = prev;
            prev = nums[i + 1];
        }
        
        return Math.max(nums[0], nums[1]);
    }
}