class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int start = 0, end = n - 1;
     
        while(start <= end){
            int mid = start + (end - start) / 2;
            if((mid < n - 1 && nums[mid + 1] != nums[mid]) && (mid > 0 && nums[mid - 1] != nums[mid])) return nums[mid];
            else if(mid == 0 && nums[mid + 1] != nums[mid] || mid == n - 1 && nums[mid - 1] != nums[mid]) return nums[mid];
            if((mid % 2 == 0 && mid < n - 1 && nums[mid + 1] == nums[mid]) || (mid % 2 != 0 && mid > 0 && nums[mid - 1] == nums[mid])) start = mid + 1;
            else end = mid - 1;
        }
        
        return -1;
    }
}