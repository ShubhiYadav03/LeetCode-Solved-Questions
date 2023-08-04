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
        int dp[][] = new int[n][W + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, wt, val, W, dp);
    }
    
    static int solve(int idx, int currWt, int wt[], int val[], int totalWt, int dp[][]){
        int n = wt.length;
        if(idx == n){
            return 0;
        }
        if(dp[idx][currWt] != -1) return dp[idx][currWt];
        int pick = 0;
        if(wt[idx] + currWt <= totalWt){
            pick = val[idx] + solve(idx, currWt + wt[idx], wt, val, totalWt, dp);
        }
        int notpick = solve(idx + 1, currWt, wt, val, totalWt, dp);
        
        return dp[idx][currWt] = Math.max(pick, notpick);
    }
}