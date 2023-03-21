class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 1) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum = sum/2;
        
        int dp[][] = new int[n][sum + 1];
        
        return solve(0, n, sum, nums, 0, dp);
    }
    
    boolean solve(int i, int n, int k, int arr[], int sum, int dp[][]){
        if(sum > k) return false;
        if(sum == k) return true;

        if(i == n) return false;
        if(dp[i][sum] != 0){
            return dp[i][sum] == 1;
        }
        dp[i][sum] = 1;
        if(sum + arr[i] <= k){
            if(solve(i + 1, n, k, arr, sum + arr[i], dp)){
                return true;
            }
        }
            if(solve(i + 1, n, k, arr, sum, dp)){
                return true;
            }
        
        dp[i][sum] = -1;
        return false;
        
    }
}