class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        Arrays.sort(nums);
        int max=0;
        int maxSub=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1) max=max+1;
            else if(nums[i]==nums[i+1]) continue;
            else max=0;
            
            maxSub=Math.max(max,maxSub);
            
        }
        
        return maxSub+1;
    }
}