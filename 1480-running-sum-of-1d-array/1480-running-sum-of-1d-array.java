class Solution {
    public int[] runningSum(int[] nums) {
        int sum=0, x=nums.length;
        int[] runningSum=new int[x];
        
        for(int i=0;i<x;i++){
            sum=sum+nums[i];
runningSum[i]=sum;
        }
        return runningSum;  
    }
}