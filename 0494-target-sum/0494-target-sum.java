class Solution {
    Map<String, Integer> map = new HashMap();
    public int findTargetSumWays(int[] nums, int target) {
        // int col = Math.abs(target);
        
        return solve(0, target, 0, nums);
        }
    
    int solve(int idx, int target, int sum, int[] nums){
        int n = nums.length;
        String key=idx+"@"+sum;
        if(map.containsKey(key)) return map.get(key);
        
        if(idx == n && sum == target){
            return 1;
        }
        
        if(idx == n) {
            return 0;
        }
        
        int add = solve(idx + 1, target, sum + nums[idx], nums);
        
        int sub = solve(idx + 1, target, sum - nums[idx], nums);
        
        map.put(key, add + sub);
        return add + sub;
    }
}