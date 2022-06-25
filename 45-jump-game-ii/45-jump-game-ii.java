class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int l=0,r=0;
        while(r<nums.length-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest,  nums[i] + i);
            }
            l = r + 1; 
            r = farthest;
            ans+=1;
        }
        return ans;
    }
}