class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum = 0;
        for(int num : nums){
            targetSum += num;
        }
        if(targetSum % 2 == 1) return false;
        targetSum = targetSum/2;
        int[][] dp = new int[nums.length][targetSum + 1];
        return findSum(0, 0, targetSum, nums, dp) == 1;
    }
    
    int findSum(int i, int sum, int targetSum, int[] arr, int[][] dp){
        if(sum == targetSum) return 1;
        if(i >= arr.length) return -1;
        
        if(dp[i][sum] != 0) return dp[i][sum];
        if(arr[i] + sum <= targetSum){
            if(findSum(i + 1, sum + arr[i], targetSum, arr, dp) == 1) return dp[i][sum] = 1;
        }
        return dp[i][sum] = findSum(i + 1, sum, targetSum, arr, dp);
    }
}