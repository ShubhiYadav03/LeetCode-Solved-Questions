class Solution {
    public void sortColors(int[] nums) {
        int start=0,end=nums.length-1, m=0;
        while(start<=end){
            if(nums[start]==1) start++;
            else if(nums[start]==2) {
                swap(nums,start,end);
                end--;
            } 
            else if(nums[start]==0) {
                 swap(nums,start,m);
                m++;
                start++;
            }
        }
    }
    void swap(int[] arr,int i,int j){
    int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}