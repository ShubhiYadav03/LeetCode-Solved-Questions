class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0||nums.length==1) return;
        int left=nums.length-2;
        int end=nums.length-1;
        int i;
        if(nums[end]>nums[left]){
                swap(nums,left,end);          
                }
        else{
            
        for( i=nums.length-3;i>=0;i--){
            if(nums[i]>=nums[left]){
                       left--;
                }else{
                while(nums[i]>=nums[end]){
                    end--;
                }
                swap(nums,i,end);
                reverse(nums,left,nums.length-1);
                break;
                }
            }
            
            if(i==-1) reverse(nums,0,nums.length-1);
        }

    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    
    void reverse(int[] arr,int i,int j){  
        while(i<j){
            swap(arr,i,j);   
            i++;
            j--;
        }
    }
}