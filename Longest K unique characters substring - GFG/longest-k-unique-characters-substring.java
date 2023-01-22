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
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else map.put(ch, 1);
            
            if(map.size() == k){
                max = Math.max(max, i - j + 1);
            }
            if(map.size() > k){
                while(map.size() > k){
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                    j++;
                }
            }
        }
        return max;
    }
}