class Solution {
    int ans;
    public int minOperations(int[] nums, int x) {
      int i=0,j=0,sum=0;
        for(i=0;i<nums.length;i++){
           sum+=nums[i]; 
        }
        sum-=x;
        int nSum=0,max=0;
        boolean found=false;
        for(i=0;i<nums.length;i++){
           nSum+=nums[i];
           while(nSum>sum && i>=j){
               nSum-=nums[j];
               j++;
           }
           if(nSum==sum){
               found=true;
               max=Math.max(max,i-j+1);
           } 
                
        }
        
        return (found) ? nums.length-max : -1;
    }
}