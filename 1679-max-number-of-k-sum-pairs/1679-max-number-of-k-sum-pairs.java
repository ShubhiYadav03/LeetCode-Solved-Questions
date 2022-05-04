class Solution {
    public int maxOperations(int[] nums, int k) {
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int count=0,i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==k){
               count++;
                i++;
                j--;
            }
            else if(nums[i]+nums[j]>k) j--;
            else if(nums[i]+nums[j]<k) i++;
        }
        
        return count;
    }
}