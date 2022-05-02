class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length<2) return nums;
        int i=0,j=nums.length-1;
        while(i<nums.length&&j>=0&&i<j){
            while(i<nums.length&&nums[i]%2==0) i++;
            while(j>=0&&nums[j]%2==1) j--;
            if(i<nums.length&&j>=0&&i<j) swap(nums,i,j);
             i++;
             j--;
        } 
       return nums;
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}