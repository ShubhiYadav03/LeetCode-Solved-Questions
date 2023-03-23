//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
        // int[][] dp = new int[n][W + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return solve(0, W, wt, val, n, dp);
        
        return tabulation(W, wt, val, n);
    } 
    
    static int tabulation(int W, int wt[], int val[], int n){
        int[][] dp = new int[n + 1][W + 1];
       
        for(int idx = n - 1; idx >= 0; idx--){
            for(int cap = 0; cap <= W; cap++){
                // if(idx == n || cap == 0) dp[idx][cap] = 0;
                // else{
                int pick = 0;
                if(cap >= wt[idx])
                    pick = dp[idx][cap - wt[idx]] + val[idx];
        
                int notpick = dp[idx + 1][cap];  
                dp[idx][cap] = Math.max(pick, notpick);
            // }
            }
        }
        
        return dp[0][W];
    }
    
    static int solve(int idx, int cap, int wt[], int val[], int n, int[][] dp){
        if(idx == n || cap == 0){
            return 0;
        }
        
        if(dp[idx][cap] != -1){
            return dp[idx][cap];
        }
        
        int pick = 0;
        if(cap >= wt[idx]){
            pick = solve(idx, cap - wt[idx], wt, val, n, dp) + val[idx];
        }
        
        int notpick = solve(idx + 1, cap, wt, val, n, dp); 
        
        return dp[idx][cap] = Math.max(pick, notpick);
    }
}