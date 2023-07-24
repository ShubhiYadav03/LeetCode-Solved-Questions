class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(count != 0 && num == result){
                count++;
            }
            else if(count != 0 && num != result){
                count--;
            }
            if(count == 0 && num != result){
                result = num;
                count++;
            }
        }
        return result;
    }
}