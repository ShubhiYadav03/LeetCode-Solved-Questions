class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target) return 0;
        else
            return -1;
        }
        int p = peakIndex(nums);  
        int ind = -1;
        if(target >= nums[0])
            ind = binarySearch(nums, target, 0, p);
        else 
            ind = binarySearch(nums, target, p + 1, nums.length - 1);
       
    return ind;
    }
    
    public int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
                int mid = start + (end - start) / 2;
            
                if(nums[mid] == target) return mid;
                if(nums[mid] > target) end = mid - 1;
                else start = mid + 1;
        }
        return -1;
    }
    
    public int peakIndex(int[] nums){
        int start = 0, end = nums.length - 1;
        
        while(start <= end){ 
            int mid = start + (end - start) / 2;
            
            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return mid;
            
            if(mid > 0 && nums[mid - 1] > nums[mid]) return mid - 1;
          
            if(nums[mid] >= nums[start]) start = mid + 1;
                
            else end = mid - 1;   
        }
        
        return end;
    }
}