//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String text1, String text2, int m, int n){
        if(text1.equals(text2)) return text1.length();
        
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, text1, text2, dp);
    }
    
    int solve(int idx1, int idx2, String text1, String text2, int dp[][]){
        int m = text1.length(), n = text2.length();
        if(idx1 == m || idx2 == n) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        int pick = 0, i = idx1, j = idx2;
        while(i < m && j < n && text1.charAt(i) == text2.charAt(j)){
            i++;
            j++;
            pick++;
        }
        int notpick1 = solve(idx1, idx2 + 1, text1, text2, dp);
        int notpick2 = solve(idx1 + 1, idx2, text1, text2, dp);
        
        return dp[idx1][idx2] = Math.max(pick, Math.max(notpick1, notpick2));
    }
}