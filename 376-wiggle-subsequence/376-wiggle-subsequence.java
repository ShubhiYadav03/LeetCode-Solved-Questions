class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        if(nums.length == 2 && nums[0] != nums[1]) return 2;
        else if(nums.length == 2 && nums[0] == nums[1]) return 1;
        int count = 0, j = 1;
        while(j < nums.length && nums[j] - nums[j - 1] == 0){
            j++;
        }
        if(j == nums.length) return 1;
        count = (nums[j] - nums[j - 1] > 0) ? 0 : 1;
        int currSize = 1;

        for(int i = j; i < nums.length; i++){
            if(count == 1){
                if(nums[i] - nums[i - 1] < 0){
                    currSize++;
                    count = 0;
                }
            }
            else if(count == 0){
                if(nums[i] - nums[i - 1] > 0){
                    currSize++;
                    count = 1;
                }
            }        
        }
        
        return currSize;
    }
}