class Solution {
    public int[] plusOne(int[] nums) {
        if(nums[nums.length - 1] < 9){
            nums[nums.length - 1] = nums[nums.length - 1] + 1;
            return nums;
        }
        int carry = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            carry = (nums[i] + 1) / 10;
            nums[i] = (nums[i] + 1) % 10;
            if(carry == 0) break;
        }
        
        if(carry != 0){
            int[] arr = new int[nums.length + 1];
            arr[0] = carry;
            System.arraycopy(nums, 0, arr, 1, nums.length);
            return arr;
        }
        
        return nums;
    }
}