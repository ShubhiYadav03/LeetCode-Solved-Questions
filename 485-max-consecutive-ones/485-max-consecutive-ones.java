class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,maxLen=0;
        for(int i=0;i<nums.length;i++){
            max=(nums[i]==1) ? max+1 : 0;
            maxLen=Math.max(max,maxLen);
        }
        return maxLen;
    }
}