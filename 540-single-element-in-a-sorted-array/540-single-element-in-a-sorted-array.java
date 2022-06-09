class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int start=0,end=nums.length-1;
         if(nums[start]!=nums[start+1]) return nums[start];
         else start+=2;
         if(nums[end]!=nums[end-1]) return nums[end];
          else end-=2;
        while(start<=end){
            int mid=start+(end-start)/2;         
           

//             if(nums[start]!=nums[start+1]) return nums[start];
//             else start+=2;
//             if(nums[end]!=nums[end-1]) return nums[end];
//             else end-=2;
           
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])
                return nums[mid];   
            if((nums[mid]==nums[mid-1]&&mid%2==1)||(nums[mid]==nums[mid+1]&&mid%2==0))                       start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
}