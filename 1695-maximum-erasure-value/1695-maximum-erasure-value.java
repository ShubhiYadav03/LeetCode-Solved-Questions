class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs=new HashSet();
        int sum=0,maxSum=0,l=0;
        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i])){
                  while(hs.contains(nums[i])) {
                      sum-=nums[l];
                     hs.remove(nums[l++]);                  
            }}
            hs.add(nums[i]);
            sum+=nums[i];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}