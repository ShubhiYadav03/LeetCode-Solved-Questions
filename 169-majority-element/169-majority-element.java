class Solution {
    public int majorityElement(int[] nums) {
        int res=nums[0],count=0;
        for(int num : nums){
            if(count == 0) res = num;
            count += (res == num) ? 1 : -1;
        }
        
        return res;
    }
}