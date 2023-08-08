//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        if(s.length() < k) return -1;
        int ans = 0, curr = 0, j = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char chi = s.charAt(i);
            map.put(chi, map.getOrDefault(chi, 0) + 1);
            curr++;
            
            while(map.size() == k + 1){
                    char ch = s.charAt(j);
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) == 0) map.remove(ch);
                    j++;
                    curr--;
            }
            
            if(map.size() == k){
                ans = Math.max(ans, curr);
            }
        }
        return (ans == 0) ? -1 : ans;
    } 
}