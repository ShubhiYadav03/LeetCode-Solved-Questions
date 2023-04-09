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
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        int idx = 0, max = dp[0];
        for(int i = 1; i < n; i++){
            prev[i] = i;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        prev[i] = j;
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                    idx = i;
                }
            } 
        }
       

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);
        while(idx != prev[idx]){
            idx = prev[idx];
            ans.add(0, arr[idx]);
        }
        return ans;
    }
}
