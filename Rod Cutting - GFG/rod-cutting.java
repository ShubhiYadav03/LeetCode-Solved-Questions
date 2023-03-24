//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(1, n, price, n, dp);
    }
    
    int solve(int idx, int len, int price[], int n, int[][] dp){
        if(idx == n + 1 || len == 0){
            return 0;
        }
        
        if(dp[idx][len] != -1){
            return dp[idx - 1][len];
        }
        
        int pick = 0;
        if(len >= idx){
            pick = solve(idx, len - idx, price, n, dp) + price[idx - 1];
        }
        int notpick = solve(idx + 1, len, price, n, dp);
        
        return dp[idx][len] = Math.max(pick, notpick);
    }
}