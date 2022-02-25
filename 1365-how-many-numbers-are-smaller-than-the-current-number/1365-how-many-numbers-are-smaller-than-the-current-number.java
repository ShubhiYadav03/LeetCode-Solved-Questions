class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int x=nums.length;
        int[] ans=new int[x];
        for(int i=0;i<x;i++){
            int sum=0;
             for(int j=0;j<x;j++){
            if(nums[i]>nums[j]){
                sum++;
            }
                 ans[i]=sum;
        }
        }
        return ans;
    }
}