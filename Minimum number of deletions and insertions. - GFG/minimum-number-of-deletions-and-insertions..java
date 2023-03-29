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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    int n = str2.length(), m = str1.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0,str1, str2, dp);
    }

    int solve(int idx1, int idx2, String str1, String str2, int[][] dp){
        int n = str2.length(), m = str1.length();
        if(idx1 == m && idx2 == n) return 0;
        if(idx2 == n) return m - idx1;
        if(idx1 == m) return n - idx2;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        int pick = Integer.MAX_VALUE;
        if(str1.charAt(idx1) == str2.charAt(idx2)){
            pick = solve(idx1 + 1, idx2 + 1, str1, str2, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int notpick = Math.min(solve(idx1 + 1, idx2, str1, str2, dp), solve(idx1, idx2 + 1, str1, str2, dp)) + 1;
        
        return dp[idx1][idx2] = notpick;
    
	} 
}