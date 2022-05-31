class Solution {
    public void sortColors(int[] nums) {
        int start=0,end=nums.length-1, m=0;
        while(m<=end){
            if(nums[m]==1) m++;
            else if(nums[m]==2) {
                swap(nums,m,end);
                end--;
            } 
            else if(nums[m]==0) {
                 swap(nums,m,start);
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