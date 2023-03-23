//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, W, wt, val, n, dp);
    } 
    
    static int tabulatin(int W, int wt[], int val[], int n){
        int[][] dp = new int[n + 1][W + 1];
        
        for(int idx = n - 1; idx >= 0; idx--){
            for(int cap = 0; cap <= W; cap++){
                // if(idx == n || cap == 0) dp[n][cap] = 0;
                int pick = 0;
                if(cap >= wt[idx])
                    pick = dp[idx + 1][cap - wt[idx]] + val[idx];
        
                int notpick = dp[idx + 1][cap];  
                dp[idx][cap] = Math.max(pick, notpick);
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
            pick = solve(idx + 1, cap - wt[idx], wt, val, n, dp) + val[idx];
        }
        
        int notpick = solve(idx + 1, cap, wt, val, n, dp); 
        
        return dp[idx][cap] = Math.max(pick, notpick);
    }
}


