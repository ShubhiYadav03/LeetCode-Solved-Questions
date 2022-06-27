class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length <2) return false;
        // int pairs=nums.length/2;
        int ans=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=2){
            ans = nums[i] ^ nums[i-1]; 
            if(ans!=0)return false;
        }
        return ans == 0;
    }
}