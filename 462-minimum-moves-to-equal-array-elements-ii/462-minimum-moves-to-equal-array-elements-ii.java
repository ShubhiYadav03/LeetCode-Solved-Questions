class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        Arrays.sort(nums);
        int median = (nums.length%2 == 1) ? nums[nums.length/2] : (nums[nums.length/2] + nums[nums.length/2 - 1])/2;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.abs(nums[i] - median); 
        }
        
        return ans;
     }
}