class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(n == 1) return nums;
        int[] ans = new int[n * 2];
        int j = 0;
        for(int i = 0; i < n; i++){
            ans[j] = nums[i];
            ans[j + 1] = nums[i + n];
            j += 2;
        }
        
        return ans;
    }
}