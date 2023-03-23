//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int arr[]){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        // S1 + S2 = sum
        // S1 - S2 = d
        // 2S1 = sum + d
        if((sum + d) % 2 != 0) return 0;
        int target = (sum + d)/2;
        
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = solve(0, target, 0, arr, dp);
        return ans;
    }
    
    int solve(int idx, int target, int sum, int[] arr, int[][] dp){
        int n = arr.length;
        if(idx == n && sum == target){
            return 1;
        }
        
        if(idx == n){
            return 0;
        }
        
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int pick = 0;
        if(target >= sum + arr[idx]){
            pick = solve(idx + 1, target, sum + arr[idx], arr, dp) % 1000000007;
        }
        int notpick = solve(idx + 1, target, sum, arr, dp) % 1000000007;
        
        
        return dp[idx][sum] = (pick + notpick) % 1000000007;
    
    }
}