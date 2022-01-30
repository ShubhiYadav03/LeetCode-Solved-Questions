class Solution {
    public void rotate(int[] nums, int k) {
          k = k % nums.length; 
        if(k < 0){ 
            k += nums.length;
        }
   reverse(nums, 0, nums.length - k - 1);
   
        reverse(nums, nums.length - k, nums.length - 1);
      
        reverse(nums, 0, nums.length - 1);
    }
        
    void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}