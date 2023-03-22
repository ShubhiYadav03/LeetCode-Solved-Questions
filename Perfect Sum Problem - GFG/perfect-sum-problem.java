//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    // int count = 0;
	public int perfectSum(int arr[],int n, int target) 
	{ 
	    int dp[][] = new int[n][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, target, arr, 0, dp);
	} 
	
	int solve(int idx, int target, int[] arr, int sum, int dp[][]){
        int n = arr.length;
        if(idx == n && sum == target){
            return 1;
        }
        
        if(idx == n) {
            return 0;
        }
        
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int pick = 0;
        if(target >= sum + arr[idx]){
            pick = solve(idx + 1, target, arr, sum + arr[idx], dp) % 1000000007;
        }
        int notpick = solve(idx + 1, target, arr, sum, dp) % 1000000007;
        
        
        return dp[idx][sum] = (pick + notpick) % 1000000007;
    }
}