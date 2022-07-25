

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int[] arr = new int[]{-1, -1};
        while(low <= high) {
            if((nums[low] == target) && (nums[high] == target)) {
                arr[0] = low;
                arr[1] = high;
                break;
            } else {
                if(nums[low] != target) low++;
                if(nums[high] != target) high--;
            }
        }
        return arr;
    }
}

   

    


