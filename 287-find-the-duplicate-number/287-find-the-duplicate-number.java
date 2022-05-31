class Solution {
    public int findDuplicate(int[] nums) {
     int n=nums.length;
        int i=0;
        while(i<n){
            int correct =nums[i]-1;
          if(nums[i]!=nums[correct]){
              swap(nums,i,correct);
          }else i++;
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return nums[j];
            }
        }
        return -1;
    }
    
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}