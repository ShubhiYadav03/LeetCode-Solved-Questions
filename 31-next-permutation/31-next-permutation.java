class Solution {
   public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) return ;
        int left = nums.length-2;
        int right = nums.length-1;
        
        while(left >= 0 && nums[left] >= nums[left+1]){
            left--;
        }
        if(left >= 0){
            while(right >= 0 && nums[right] <= nums[left]){
            right--;
        }
        swap(nums,left,right);
        }
        
        reverse(nums,left+1,nums.length-1);
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