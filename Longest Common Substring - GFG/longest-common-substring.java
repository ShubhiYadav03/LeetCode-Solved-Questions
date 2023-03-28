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
        // int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for(int idx1 = m - 1; idx1 >= 0; idx1--){
            for(int idx2 = n - 1; idx2 >= 0; idx2--){
                int equal = 0;
                if(text1.charAt(idx1) == text2.charAt(idx2))
                    equal = dp[idx1 + 1][idx2 + 1] + 1;
        
                max = Math.max(equal, max);
                dp[idx1][idx2] = equal;
            }
        }
        return max;
    }
}